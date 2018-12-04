package my.web.controller;

import my.web.domain.Customer;
import my.web.domain.Role;
import my.web.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping
    public String userList(@RequestParam(required = false, defaultValue = "") String searchfiltr,
                           @RequestParam(required = false,defaultValue = "") String search,
                           Model model) {

        Iterable<Customer> customers;

        if(search != null && !search.isEmpty() && !searchfiltr.equals("Search for")) {
            customers = customerRepo.findByUsernameLike(search);
        } else {
            customers = customerRepo.findAll();
        }

        model.addAttribute("customers", customers);
        model.addAttribute("search", search);

        return "userList";
    }

    @GetMapping("{customer}")
    public String userEditForm(@PathVariable Customer customer, Model model) {
        model.addAttribute("user", customer);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam("customerUserName") String username,
            @RequestParam Map<String, String> form,
            @RequestParam("customerRowId") Customer customer){

        customer.setUsername(username);

       Set<String> roles = Arrays.stream(Role.values())
               .map(Role::name)
               .collect(Collectors.toSet());

       customer.getRoles().clear();

       for (String key : form.keySet()){
           if (roles.contains(key)) {
               customer.getRoles().add(Role.valueOf(key));
           }
       }

        customerRepo.save(customer);

        return "redirect:/user";
    }

}
