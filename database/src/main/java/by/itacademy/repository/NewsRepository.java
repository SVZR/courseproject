package by.itacademy.repository;

import by.itacademy.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findAll();
    
}
