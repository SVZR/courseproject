package by.itacademy.service;

import by.itacademy.entity.Message;
import by.itacademy.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(Message message) {
        System.out.println(message);
        message.setTimeStamp(LocalDateTime.now());
        messageRepository.save(message);
    }

    @Override
    public List<Message> getAllInputMessagesByUserLogin(String userLogin) {
        return messageRepository.findAllByUserUserLoginOrderByTimeStamp(userLogin);
    }

    @Override
    public List<Message> getAllOutputMessagesByUserLogin(String userLogin) {
        return messageRepository.findAllByFromUserUserLoginOrderByTimeStamp(userLogin);
    }
}
