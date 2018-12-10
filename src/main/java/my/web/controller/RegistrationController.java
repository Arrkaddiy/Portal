package my.web.controller;

import my.web.domain.User;
import my.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     * Страница регистрации
     * @return
     */
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    /**
     * Добавление пользователя
     * @param user
     * @param model
     * @return
     */
    @PostMapping("/registration")
    public String addCustomer(User user, Model model){

        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
