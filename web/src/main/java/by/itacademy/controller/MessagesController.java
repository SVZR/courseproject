package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagesController extends BaseController {

    @GetMapping("/messages")
    public String showMessagePage() {
        return "messages";
    }
}
