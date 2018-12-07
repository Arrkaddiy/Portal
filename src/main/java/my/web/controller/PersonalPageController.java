package my.web.controller;

import my.web.domain.Customer;
import my.web.repos.CustomerRepo;
import my.web.service.FileService;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/personalpage")
public class PersonalPageController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private FileService fileService;
    @Autowired
    private IncludeMailService includeMailService;

    @Value("${upload.path}")
    private String uploadpath;

    @GetMapping
    public String personalPage(@AuthenticationPrincipal Customer customerAuth, Model model) {

        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customerAuth.getUsername()));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        return "personalPage";
    }

    @GetMapping("{customer}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String personalPageId(@AuthenticationPrincipal Customer customerAuth,
                                 Customer customer, Model model) {

        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customerAuth.getUsername()));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customer.getUsername()));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        return "personalPage";
    }

    @PostMapping
    public String addPicture(@AuthenticationPrincipal Customer customerAuth,
                             @RequestParam(name = "file") MultipartFile file,
                             Model model) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadpath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidfile = UUID.randomUUID().toString();
            String resultfilename = uuidfile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadpath + "/" + resultfilename));

            customerAuth.setAvatarname(resultfilename);
        }

        customerRepo.save(customerAuth);

        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customerAuth.getUsername()));

        return "personalPage";
    }

    @PostMapping("{customer}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addPictureID(@RequestParam(name = "file") MultipartFile file,
                               Customer customer, Model model) throws IOException {

        if (fileService.addPicture(file) != null){
            customer.setAvatarname(fileService.addPicture(file));
        }
        customerRepo.save(customer);

        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customer.getUsername()));

        return "personalPage";
    }

}
