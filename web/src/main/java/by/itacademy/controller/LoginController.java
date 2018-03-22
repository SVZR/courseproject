package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author kirylhrybouski
 */
@Controller
public class LoginController extends BaseController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
