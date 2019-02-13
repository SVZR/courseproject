package by.itacademy.repository;

import by.itacademy.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findAll();
    
}
