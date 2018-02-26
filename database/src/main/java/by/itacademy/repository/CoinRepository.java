package by.itacademy.repository;

import by.itacademy.entity.Coin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinRepository extends CrudRepository<Coin, Long> {

    @Query("select c from Coin c where c.series.theme.country.id = ?1")
    List<Coin> findCoinsByCountryId(long id);
}
