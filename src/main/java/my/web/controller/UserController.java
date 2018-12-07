package my.web.controller;

import my.web.domain.Customer;
import my.web.domain.Role;
import my.web.repos.CustomerRepo;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    @GetMapping
    public String userList(@AuthenticationPrincipal Customer customerAuth,
                           @RequestParam(required = false, defaultValue = "") String searchfiltr,
                           @RequestParam(required = false,defaultValue = "") String search,
                           Model model) {

        Iterable<Customer> customers;

        if(search != null && !search.isEmpty() && !searchfiltr.equals("Search for")) {
            customers = customerRepo.findByUsernameLike(search);
        } else {
            customers = customerRepo.findAll();
        }

        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customerAuth.getUsername()));
        model.addAttribute("customers", customers);
        model.addAttribute("search", search);
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));

        return "userList";
    }

    @GetMapping("{customer}")
    public String userEditForm(@AuthenticationPrincipal Customer customerAuth,
                               @PathVariable Customer customer, Model model) {

        model.addAttribute("user", customer);
        model.addAttribute("roles", Role.values());
        model.addAttribute("invoicessize", invoiceService.customerInvoiceOwner(customerAuth));
        model.addAttribute("customer", customerRepo.findByUsernameIgnoreCase(customerAuth.getUsername()));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(customerAuth));
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam("UserName") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("phone") String phone,
            @RequestParam("country") String country,
            @RequestParam("sity") String sity,
            @RequestParam("address") String address,

            @RequestParam Map<String, String> form,
            @RequestParam("customerRowId") Customer customer){

        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setPhone(phone);
        customer.setCountry(country);
        customer.setSity(sity);
        customer.setAddress(address);

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
    @GetMapping("/active/{customer}")
    public String active(@PathVariable Customer customer) {

        customer.setActive(true);
        customerRepo.save(customer);

        return "redirect:/user";
    }

    @GetMapping("/terminate/{customer}")
    public String terminate(@PathVariable Customer customer) {

        customer.setActive(false);
        customerRepo.save(customer);

        return "redirect:/user";
    }

}
