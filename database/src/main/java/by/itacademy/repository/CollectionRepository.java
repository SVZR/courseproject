package by.itacademy.repository;

import by.itacademy.entity.Collection;
import by.itacademy.entity.SaleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    List<Collection> findAllByCoinDescriptionCoinIdAndUserUserLogin(long coinDescriptionCoinId, String userLogin);

    Collection findCollectionByCoinDescriptionIdAndUserUserLogin(long coinDescriptionId, String userLogin);

    List<Collection> findAllBySaleAndAmountGreaterThanAndCostGreaterThan(SaleType sale, long amount, BigDecimal cost);

    void deleteCollectionsByUserId(long userId);
}
