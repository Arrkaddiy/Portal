package my.web.controller;

import my.web.domain.Invoice;
import my.web.domain.Customer;
import my.web.repos.InvoiceRepo;
import my.web.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private InvoiceRepo invoiceRepo;

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model){

        Iterable<Invoice> invoices;

        if(filter != null && !filter.isEmpty()) {
            invoices = invoiceRepo.findByInvoicedate(filter);
        } else {
            invoices = invoiceRepo.findAll();
        }

        model.addAttribute("invoices", invoices);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal Customer customer,
            @RequestParam String date,
            @RequestParam String point,
            Map<String, Object> model) {

        Invoice invoice = new Invoice(date, point, customer);
        invoiceRepo.save(invoice);

        Iterable<Invoice> invoices = invoiceRepo.findAll();
        model.put("invoices", invoices);

        return "main";
    }

}
