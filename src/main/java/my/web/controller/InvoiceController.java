package my.web.controller;

import my.web.domain.Customer;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private IncludeMailService includeMailService;

    @GetMapping("/inprogress")
    public String inprogress(
            @AuthenticationPrincipal Customer customerAuth,
            Model model){

        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        model.addAttribute("invoicesinprogress", invoiceService.inProgress(customerAuth));

        return "invoiceInProgress";
    }

}
