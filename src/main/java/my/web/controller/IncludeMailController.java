package my.web.controller;

import my.web.domain.IncludeMail;
import my.web.domain.User;
import my.web.service.IncludeMailService;
import my.web.service.InvoiceService;
import my.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class IncludeMailController {

    @Autowired
    private UserService userService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private IncludeMailService includeMailService;

    /**
     * Страница нового сообщения
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("new_message")
    public String newMessage(@AuthenticationPrincipal User userAuth,
                             Model model){


        model.addAttribute("userAuth", userAuth);

        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));
        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));

        return "newMessage";
    }

    /**
     * Страница ответа
     * @param userAuth
     * @param userTo
     * @param model
     * @return
     */
    @GetMapping("new_message/{userTo}")
    public String newMessageUser(@AuthenticationPrincipal User userAuth,
                                 @PathVariable String userTo, Model model){

        model.addAttribute("userAuth", userAuth);
        model.addAttribute("userTo", userService.loadUserObjByUsername(userTo));

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "newMessage";
    }

    /**
     * Страница чтения сообщения
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("new_message/read/{includeMail}")
    public String newMessageUserRead(@AuthenticationPrincipal User userAuth,
                                     IncludeMail includeMail, Model model){
        includeMail.setRead(true);
        includeMailService.save(includeMail);

        model.addAttribute("userAuth", userAuth);
        model.addAttribute("mail", includeMail);

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "newMessageRead";
    }

    /**
     * Отправка сообщения
     * @param usernameFrom
     * @param usernameTo
     * @param Title
     * @param Message
     * @return
     */
    @PostMapping
    public String sendMessage(
            @RequestParam("usernameFrom") String usernameFrom,
            @RequestParam("usernameTo") String usernameTo,
            @RequestParam("Title") String Title,
            @RequestParam("Message") String Message) {

        includeMailService.sendMessage(usernameFrom, usernameTo, Title, Message);

        return "redirect:/mail/output";
    }

    /**
     * Список входящих
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("/input")
    public String inputMessage(@AuthenticationPrincipal User userAuth,
                                Model model){

        model.addAttribute("userAuth", userAuth);
        model.addAttribute("mailsIn", includeMailService.myInboxMail(userAuth));

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "inboxMessage";
    }

    /**
     * Список исходящих
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping("/output")
    public String outputMessage(@AuthenticationPrincipal User userAuth,
                                Model model){

        model.addAttribute("userAuth", userAuth);
        model.addAttribute("mailsOut", includeMailService.myOutputMail(userAuth));

        model.addAttribute("invoicesNum", invoiceService.userInvoiceOwner(userAuth));
        model.addAttribute("myInboxMail", includeMailService.myInboxMailTrueNumber(userAuth));

        return "outputMessage";
    }
}
