package by.itacademy.repository;

import by.itacademy.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    List<Theme> findAll();
}
