package by.itacademy.repository;

import by.itacademy.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface CoinRepository extends JpaRepository<Coin, Long> {

    @Query("select c from Coin c join fetch c.coinDescriptions cd join fetch cd.metal where c.id = :coinId")
    Coin findCoinByIdFetchedCoinDescription(@Param("coinId") long coinId);

    @Query("select c from Coin c join fetch c.coinDescriptions cd join fetch cd.metal join cd.collections col join col.user u where c.id = ?1 and u.userLogin = ?2 and col.amount > 0")
    Coin findCoinByIdAndUserLoginInCollection(long coinId, String userLogin);

    List<Coin> findCoinsByNameLike(String coinName);
}
