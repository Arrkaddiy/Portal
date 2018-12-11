package my.web.controller;

import my.web.domain.Invoice;
import my.web.domain.User;
import my.web.service.InvoiceService;
import my.web.service.SupportService;
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
    private SupportService supportService;

    /**
     * Главная старница
     * @param userAuth
     * @param filter
     * @param model
     * @return main
     */
    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User userAuth,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model){

        model.addAttribute("userAuth", userAuth);

        model.addAttribute("filter", filter);
        model.addAttribute("invoices", invoiceService.filter(filter));

        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "main";
    }

    /**
     * Добавление
     * @param userAuth
     * @param date
     * @param point
     * @return
     */
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User userAuth,
            @RequestParam String date,
            @RequestParam String point) {

        Invoice invoice = new Invoice(date, point, userAuth);
        invoiceService.save(invoice);

        return "redirect:/main";
    }

}
