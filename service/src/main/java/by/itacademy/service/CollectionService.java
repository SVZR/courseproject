package by.itacademy.service;
/**
 * @author kirylhrybouski
 */
public interface CollectionService {

    void updateAmountInCollection(long coinDescriptionId, long amount, String userLogin);

    void saveAmountInCollection(long coinDescriptionId, long amount, String userLogin);
}
