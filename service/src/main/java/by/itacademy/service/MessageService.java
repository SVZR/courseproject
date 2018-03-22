package by.itacademy.service;

import by.itacademy.entity.Message;

import java.util.List;

/**
 * @author kirylhrybouski
 */
public interface MessageService {

    void createMessage(Message message);

    List<Message> getAllInputMessagesByUserLogin(String userLogin);

    List<Message> getAllOutputMessagesByUserLogin(String userLogin);
}
