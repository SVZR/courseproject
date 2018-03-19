package by.itacademy.service;

import by.itacademy.entity.CoinDescription;
import by.itacademy.entity.Collection;
import by.itacademy.entity.User;
import by.itacademy.repository.CoinDescriptionRepository;
import by.itacademy.repository.CollectionRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

    private CollectionRepository collectionRepository;
    private UserRepository userRepository;
    private CoinDescriptionRepository coinDescriptionRepository;

    @Autowired
    public CollectionServiceImpl(CollectionRepository collectionRepository, UserRepository userRepository, CoinDescriptionRepository coinDescriptionRepository) {
        this.collectionRepository = collectionRepository;
        this.userRepository = userRepository;
        this.coinDescriptionRepository = coinDescriptionRepository;
    }

    @Override
    public void updateAmountInCollection(long coinDescriptionId, long amount, String userLogin) {
        Collection collection = collectionRepository.findCollectionByCoinDescriptionIdAndUserLogin(coinDescriptionId, userLogin);
        collection.setAmount(amount);
        collectionRepository.save(collection);
    }

    @Override
    public void saveAmountInCollection(long coinDescriptionId, long amount, String userLogin) {
        Collection collection = new Collection();
        User user = userRepository.findUserByUserLogin(userLogin);
        CoinDescription coinDescription = coinDescriptionRepository.findOne(coinDescriptionId);
        collection.setUser(user);
        collection.setCoinDescription(coinDescription);
        collection.setAmount(amount);
        collectionRepository.save(collection);
    }
}
