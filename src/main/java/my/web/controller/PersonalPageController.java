package my.web.controller;

import my.web.domain.Customer;
import my.web.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${upload.path}")
    private String uploadpath;

    @GetMapping
    public String personalPage(@AuthenticationPrincipal Customer customer, Model model) {

        model.addAttribute("customer", customerRepo.findByUsername(customer.getUsername()));
        return "personalPage";
    }

    @PostMapping
    public String addPicture(@AuthenticationPrincipal Customer customer,
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

            customer.setAvatarname(resultfilename);
        }

        customerRepo.save(customer);

        model.addAttribute("customer", customerRepo.findByUsername(customer.getUsername()));

        return "personalPage";
    }

}
