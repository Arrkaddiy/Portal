package my.web.controller;

import my.web.domain.Customer;
import my.web.domain.Invoice;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal Customer customerAuth,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model){

        model.addAttribute("customer", customerAuth);
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        model.addAttribute("invoices", invoiceService.filter(filter));
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal Customer customerAuth,
            @RequestParam String date,
            @RequestParam String point) {

        Invoice invoice = new Invoice(date, point, customerAuth);
        invoiceService.save(invoice);

        return "redirect:/main";
    }

}
