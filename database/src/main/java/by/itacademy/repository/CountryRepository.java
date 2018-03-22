package by.itacademy.repository;

import by.itacademy.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface CountryRepository extends CrudRepository<Country, Long> {

    String FIND_COUNTRY_BY_ID_FETCHED_TILL_COIN = "select cnt from Country cnt join fetch cnt.themes t "
            + "join fetch t.series s join fetch s.coins where cnt.id = ?1";

    String FIND_COUNTRY_BY_ID_AND_USER_LOGIN_FETCHED_TILL_COIN = "select cnt from Country cnt "
            + "join fetch cnt.themes t join fetch t.series s join fetch s.coins c join c.coinDescriptions cd "
            + "join cd.collections col join col.user u where cnt.id = ?1 and u.userLogin = ?2";

    String FIND_COUNTRIES_BY_USER_LOGIN_COLLECTION = "select cnt from Country cnt join cnt.themes t "
            + "join t.series s join s.coins c join c.coinDescriptions cd join cd.collections col join col.user u "
            + "where u.userLogin = ?1 group by cnt.id";

    @Query(FIND_COUNTRY_BY_ID_FETCHED_TILL_COIN)
    Country findCountryByIdFetchedTillCoin(long id);

    List<Country> findAll();

    @Query(FIND_COUNTRY_BY_ID_AND_USER_LOGIN_FETCHED_TILL_COIN)
    Country findCountryByIdAndUserLoginFetchedTillCoin(long countryId, String userLogin);

    @Query(FIND_COUNTRIES_BY_USER_LOGIN_COLLECTION)
    List<Country> findCountriesByUserLoginCollection(String userLogin);

    Country getCountryById(long id);

    @Query("update Country set name = ?1 where id = ?2")
    void updateCountry(String countryName, long countryId);
}
