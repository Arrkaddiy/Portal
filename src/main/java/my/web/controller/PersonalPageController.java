package my.web.controller;

import my.web.domain.User;
import my.web.service.FileService;
import my.web.service.SupportService;
import my.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/personalPage")
public class PersonalPageController {

    @Value("${upload.path}")
    private String uploadpath;

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private SupportService supportService;

    /**
     * Персональяная страница авторизованного пользователя
     * @param userAuth
     * @param model
     * @return
     */
    @GetMapping
    public String personalPage(@AuthenticationPrincipal User userAuth, Model model) {

        model.addAttribute("user", userService.loadUserObjByUsername(userAuth.getUsername()));

        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "personalPage";
    }

    /**
     * Персональяная страница пользователя
     * @param userAuth
     * @param user
     * @param model
     * @return
     */
    @GetMapping("{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String personalPageId(@AuthenticationPrincipal User userAuth,
                                 User user, Model model) {

        model.addAttribute("user", userService.loadUserObjByUsername(user.getUsername()));
        model.addAttribute("userAuth", userService.loadUserObjByUsername(userAuth.getUsername()));

        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "personalPage";
    }

    /**
     * Добавление аватара авторизованного пользователя
     * @param userAuth
     * @param file
     * @param model
     * @return
     * @throws IOException
     */
    @PostMapping
    public String addPicture(@AuthenticationPrincipal User userAuth,
                             @RequestParam(name = "file") MultipartFile file,
                             Model model) throws IOException {

        fileService.addPicture(file, userAuth);

        model.addAttribute("user", userService.loadUserObjByUsername(userAuth.getUsername()));

        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "redirect:/personalPage";
    }

    /**
     * Добавления аватара польователю
     * @param file
     * @param user
     * @param model
     * @return
     * @throws IOException
     */
    @PostMapping("{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addPictureID(@RequestParam(name = "file") MultipartFile file,
                               User user, Model model) throws IOException {

        fileService.addPicture(file, user);

        model.addAttribute("user", userService.loadUserObjByUsername(user.getUsername()));

        return "redirect:/personalPage/{user}";
    }

    @GetMapping("getPurse")
    public String getPurse(@AuthenticationPrincipal User userAuth,
                           @RequestParam String purse, Model model) {

        userAuth.setScore(Long.valueOf(purse));
        userService.save(userAuth);

        model.addAttribute("user", userService.loadUserObjByUsername(userAuth.getUsername()));
        model.mergeAttributes(supportService.supportData(model, userAuth));

        return "redirect:/personalPage";
    }
}
