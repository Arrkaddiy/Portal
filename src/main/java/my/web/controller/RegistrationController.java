package my.web.controller;

import my.web.domain.Customer;
import my.web.domain.Role;
import my.web.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addCustomer(Customer customer, Map<String, Object> model){
        Customer customerFromDb = customerRepo.findByUsernameIgnoreCase(customer.getUsername());

        if (customerFromDb != null) {
            model.put("message", "Customer exists!");
            return "registration";
        }

        customer.setActive(true);
        customer.setAvatarname("none");
        customer.setRoles(Collections.singleton(Role.ADMIN));
        customerRepo.save(customer);

        return "redirect:/login";
    }

}
