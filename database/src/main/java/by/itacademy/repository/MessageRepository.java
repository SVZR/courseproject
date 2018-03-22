package by.itacademy.repository;

import by.itacademy.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author kirylhrybouski
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllByUserUserLoginOrderByTimeStamp(String userLogin);

    List<Message> findAllByFromUserUserLoginOrderByTimeStamp(String userLogin);
}
