package my.web.controller;

import my.web.domain.Customer;
import my.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addCustomer(Customer customer, Map<String, Object> model){

        if (!userService.addUser(customer)) {
            model.put("message", "Customer exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
