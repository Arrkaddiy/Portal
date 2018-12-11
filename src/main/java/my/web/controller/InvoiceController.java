package my.web.controller;

import my.web.domain.User;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import my.web.service.SupportService;
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
    @Autowired
    private SupportService supportService;

    /**
     * Список счетов в работе
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("/inProgress")
    public String inProgress(@AuthenticationPrincipal User userAuth, Model model){

        model.addAttribute("invoicesinprogress", invoiceService.inProgress(userAuth));

        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "invoiceInProgress";
    }

}
