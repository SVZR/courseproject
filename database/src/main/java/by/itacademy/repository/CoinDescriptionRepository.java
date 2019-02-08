package by.itacademy.repository;

import by.itacademy.entity.CoinDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kirylhrybouski
 */
public interface CoinDescriptionRepository extends JpaRepository<CoinDescription, Long> {

}
