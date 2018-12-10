package my.web.controller;

import my.web.domain.Role;
import my.web.domain.User;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import my.web.service.UserService;
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
    private UserService userService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    /**
     * Список пользователей
     * @param userAuth
     * @param searchFilter
     * @param search
     * @param model
     * @return
     */
    @GetMapping
    public String userList(@AuthenticationPrincipal User userAuth,
                           @RequestParam(required = false, defaultValue = "") String searchFilter,
                           @RequestParam(required = false,defaultValue = "") String search,
                           Model model) {

        Iterable<User> users;

        if(search != null && !search.isEmpty() && !searchFilter.equals("Search for")) {
            users = userService.loadUsersByUsernameLike(search);
        } else {
            users = userService.loadUsersAll();
        }

        model.addAttribute("userAuth", userService.loadUserObjByUsername(userAuth.getUsername()));
        model.addAttribute("users", users);
        model.addAttribute("search", search);

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "userList";
    }

    /**
     * Страница изменения пользователя
     * @param userAuth
     * @param user
     * @param model
     * @return
     */
    @GetMapping("{user}")
    public String userEditForm(@AuthenticationPrincipal User userAuth,
                               @PathVariable User user, Model model) {

        model.addAttribute("user", user);
        model.addAttribute("userAuth", userService.loadUserObjByUsername(userAuth.getUsername()));
        model.addAttribute("roles", Role.values());

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "userEdit";
    }

    /**
     * Изменение пользователя
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param phone
     * @param country
     * @param city
     * @param address
     * @param form
     * @param user
     * @return
     */
    @PostMapping
    public String userSave(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("phone") String phone,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("address") String address,

            @RequestParam Map<String, String> form,
            @RequestParam("userRowId") User user){

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setCountry(country);
        user.setCity(city);
        user.setAddress(address);

       Set<String> roles = Arrays.stream(Role.values())
               .map(Role::name)
               .collect(Collectors.toSet());

       user.getRoles().clear();

       for (String key : form.keySet()){
           if (roles.contains(key)) {
               user.getRoles().add(Role.valueOf(key));
           }
       }

        userService.save(user);

        return "redirect:/user";
    }

    @GetMapping("/active/{user}")
    public String active(@PathVariable User user) {

        user.setActive(true);
        userService.save(user);

        return "redirect:/user";
    }

    @GetMapping("/terminate/{user}")
    public String terminate(@PathVariable User user) {

        user.setActive(false);
        userService.save(user);

        return "redirect:/user";
    }

    @GetMapping("/checkIn/{user}")
    public String checkIn(@AuthenticationPrincipal User userAuth,
                          @PathVariable User user) {

        user.setSupport(userAuth);
        userService.save(user);

        return "redirect:/user";
    }

}
