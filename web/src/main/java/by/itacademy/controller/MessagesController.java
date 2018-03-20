package by.itacademy.controller;

import by.itacademy.entity.Message;
import by.itacademy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * @author kirylhrybouski
 */
@Controller
public class MessagesController extends BaseController {

    private MessageService messageService;

    @Autowired
    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ModelAttribute("inputMessages")
    public List<Message> getAllInputMessages() {
        return messageService.getAllInputMessagesByUserLogin(getUserLogin());
    }

    @ModelAttribute("outputMessages")
    public List<Message> getAllOutputMessages() {
        return messageService.getAllOutputMessagesByUserLogin(getUserLogin());
    }

    @GetMapping("/messages")
    public String showMessagePage() {
        return "messages";
    }
}
