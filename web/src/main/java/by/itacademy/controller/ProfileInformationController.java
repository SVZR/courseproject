package by.itacademy.controller;

import by.itacademy.entity.User;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author kirylhrybouski
 */
@Controller
public class ProfileInformationController extends BaseController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ProfileInformationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("user")
    public User getUserInfo() {
        return userService.getUserInformation(getUserLogin());
    }

    @GetMapping("/profileinfo")
    public String showProfileInfoPage() {
        return "profileinfo";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(String newPassword) {
        System.out.println("NEW PASS = " + newPassword);
        System.out.println("NEW PASS = " + newPassword);
        System.out.println("NEW PASS = " + newPassword);
        System.out.println("NEW PASS = " + newPassword);
        System.out.println("NEW PASS = " + newPassword);
        User user = userService.getUserInformation(getUserLogin());
        String encode = passwordEncoder.encode(newPassword);
        user.setPassword(encode);
        userService.saveUserWithNewParams(user);
        return "redirect:/profileinfo";
    }
}
