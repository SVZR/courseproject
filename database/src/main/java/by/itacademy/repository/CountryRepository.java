package by.itacademy.repository;

import by.itacademy.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    @Query("select cnt from Country cnt join fetch cnt.themes t join fetch t.series s join fetch s.coins where cnt.id = ?1")
    Country findCountryByIdFetchedTillCoin(long id);

    List<Country> findAll();

    @Query("select c.series.theme.country from Coin c where c.series.theme.country.id = ?1")
    Country findCountryById(long id);

//    @Query("select cnt from Country cnt join fetch cnt.themes t join fetch t.series s join fetch s.coins where cnt.id = ?1")
//    Country findSomething(long id);
}
