package by.itacademy.repository;

import by.itacademy.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author kirylhrybouski
 */
public interface SeriesRepository extends JpaRepository<Series, Long> {

    List<Series> findAll();
}
