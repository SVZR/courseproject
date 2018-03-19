package by.itacademy.repository;

import by.itacademy.entity.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface CollectionRepository extends CrudRepository<Collection, Long> {

    List<Collection> findAllByCoinDescriptionCoinIdAndUserLogin(long coinDescriptionCoinId, String userLogin);

    Collection findCollectionByCoinDescriptionIdAndUserLogin(long coinDescriptionId, String userLogin);
}
