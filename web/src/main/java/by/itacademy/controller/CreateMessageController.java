package by.itacademy.controller;

import by.itacademy.entity.Message;
import by.itacademy.service.MessageService;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kirylhrybouski
 */
@Controller
public class CreateMessageController extends BaseController {

    private UserService userService;
    private MessageService messageService;

    @Autowired
    public CreateMessageController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/create-message")
    public String showCreateMessagePage(Model model, @RequestParam("userLogin") String userLogin) {
        model.addAttribute("userLogin", userLogin);
        model.addAttribute("userFrom", getUserLogin());
        return "create-message";
    }

    @PostMapping("/createMessage")
    public String createMessage(String messageText, String userLogin) {
        Message message = new Message();
        message.setFromUser(userService.getUserInformation(getUserLogin()));
        message.setUser(userService.getUserInformation(userLogin));
        message.setMessageText(messageText);
        messageService.createMessage(message);
        return "redirect:/messages";
    }

}
