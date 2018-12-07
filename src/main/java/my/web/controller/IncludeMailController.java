package my.web.controller;

import my.web.domain.Customer;
import my.web.repos.CustomerRepo;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class IncludeMailController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    @GetMapping("new_message")
    public String newMessage(@AuthenticationPrincipal Customer customerAuth,
                             Model model){


        model.addAttribute("customer", customerAuth);
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));

        return "newMessage";
    }

    @GetMapping("new_message/{customerTo.username}")
    public String newMessageCustomer(@AuthenticationPrincipal Customer customerAuth,
                                     @PathVariable Customer customerTo, Model model){

        model.addAttribute("customer", customerAuth);
        model.addAttribute("customerTo", customerRepo.findByUsernameIgnoreCase(customerTo.getUsername()));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));

        return "newMessage";
    }

    @PostMapping
    public String sendMessage(
            @RequestParam("UserNameFrom") String UserNameFrom,
            @RequestParam("UserNameTo") String UserNameTo,
            @RequestParam("Title") String Title,
            @RequestParam("Message") String Message) {

        includeMailService.sendMessage(UserNameFrom, UserNameTo, Title, Message);
        return "redirect:/mail/output";
    }

    @GetMapping("/input")
    public String inputMessage(@AuthenticationPrincipal Customer customerAuth,
                             Model model){

        model.addAttribute("mailsIn", includeMailService.myInboxMailTrue(customerAuth));
        model.addAttribute("customer", customerAuth);
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));

        return "inboxMessage";
    }
}
