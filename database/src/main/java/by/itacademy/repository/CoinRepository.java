package by.itacademy.repository;

import by.itacademy.entity.Coin;
import by.itacademy.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinRepository extends CrudRepository<Coin, Long> {

    @Query("select c from Coin c where c.series.theme.country.id = ?1")
    List<Coin> findCoinsByCountryId(long id);

    Coin findCoinById(long id);

    @Query("select c from Coin c join fetch c.coinDescriptions cd where c.id = ?1")
    Coin findCoinByIdFetchedCoinDescription(long coinId);

//    @Query("select c from Coin c join fetch c.series s join fetch s.theme t join fetch t.country where c.series.theme.country.id = ?1")
//    List<Coin> findSomething(long id);
}
