package my.web.controller;

import my.web.domain.Customer;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexConrtoller {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Customer customerAuth,
                        Model model){
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        return "index";
    }
}
