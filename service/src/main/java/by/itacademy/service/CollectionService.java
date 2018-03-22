package by.itacademy.service;

import by.itacademy.entity.Collection;

import java.util.List;

/**
 * @author kirylhrybouski
 */
public interface CollectionService {

    void updateAmountInCollection(long coinDescriptionId, long amount, String userLogin);

    void saveAmountInCollection(long coinDescriptionId, long amount, String userLogin);

    List<Collection> getAllCollectionForSale();

    Collection getCollectionById(long collectionId);

    void saveChangedCollection(Collection collection);
}
