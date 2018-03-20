package by.itacademy.repository;

import by.itacademy.entity.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface ThemeRepository extends CrudRepository<Theme, Long> {

    List<Theme> findAllByCountryId(long id);

    List<Theme> findAll();
}
