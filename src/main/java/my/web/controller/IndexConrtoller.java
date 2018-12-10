package my.web.controller;

import my.web.domain.User;
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

    /**
     * Index
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User userAuth,
                        Model model){

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "index";
    }
}
