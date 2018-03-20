package by.itacademy.repository;

import by.itacademy.entity.Coin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface CoinRepository extends CrudRepository<Coin, Long> {

    @Query("select c from Coin c where c.series.theme.country.id = ?1")
    List<Coin> findCoinsByCountryId(long id);

    @Query("select c from Coin c join fetch c.coinDescriptions cd join fetch cd.metal where c.id = ?1")
    Coin findCoinByIdFetchedCoinDescription(long coinId);

    @Query("select c from Coin c join fetch c.coinDescriptions cd join fetch cd.metal join cd.collections col join col.user u where c.id = ?1 and u.userLogin = ?2 and col.amount > 0")
    Coin findCoinByIdAndUserLoginInCollection(long coinId, String userLogin);

    List<Coin> findCoinsByNameLike(String coinName);
}
