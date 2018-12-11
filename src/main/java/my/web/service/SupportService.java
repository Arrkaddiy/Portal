package my.web.service;

import my.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public class SupportService {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    public Map<String, Object> supportData(Model model, User user) {

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(user));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(user));

        return model.asMap();
    }
}
