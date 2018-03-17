package by.itacademy.repository;

import by.itacademy.entity.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThemeRepository extends CrudRepository<Theme, Long> {

    List<Theme> findAllByCountry_Id(long id);
}
