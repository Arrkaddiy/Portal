package my.web.controller;

import my.web.domain.User;
import my.web.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexConrtoller {
    @Autowired
    private SupportService supportService;

    /**
     * Index
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User userAuth,
                        Model model){

        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "index";
    }
}
