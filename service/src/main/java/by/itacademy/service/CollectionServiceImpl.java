package by.itacademy.service;

import by.itacademy.entity.CoinDescription;
import by.itacademy.entity.Collection;
import by.itacademy.entity.SaleType;
import by.itacademy.entity.User;
import by.itacademy.repository.CoinDescriptionRepository;
import by.itacademy.repository.CollectionRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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
        Collection collection = collectionRepository.findCollectionByCoinDescriptionIdAndUserUserLogin(coinDescriptionId, userLogin);
        collection.setAmount(amount);
        collectionRepository.save(collection);
    }

    @Override
    public void saveAmountInCollection(long coinDescriptionId, long amount, String userLogin) {
        Collection collection = new Collection();
        User user = userRepository.findUserByUserLogin(userLogin);
        CoinDescription coinDescription = coinDescriptionRepository.findOne(coinDescriptionId);
        collection.setSale(SaleType.NOTFORSALE);
        collection.setUser(user);
        collection.setCoinDescription(coinDescription);
        collection.setAmount(amount);
        collectionRepository.save(collection);
    }

    @Override
    public List<Collection> getAllCollectionForSale() {
        return collectionRepository.findAllBySaleAndAmountGreaterThanAndCostGreaterThan(SaleType.FORSALE, 0, BigDecimal.ZERO);
    }

    @Override
    public Collection getCollectionById(long collectionId) {
        return collectionRepository.findOne(collectionId);
    }

    @Override
    public void saveChangedCollection(Collection collection) {
        collectionRepository.save(collection);
    }
}
