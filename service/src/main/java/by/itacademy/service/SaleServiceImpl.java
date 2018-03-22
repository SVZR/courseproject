package by.itacademy.service;

import by.itacademy.entity.Collection;
import by.itacademy.entity.SaleType;
import by.itacademy.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author kirylhrybouski
 */
@Service
public class SaleServiceImpl implements SaleService {

    private final CollectionRepository collectionRepository;

    @Autowired
    public SaleServiceImpl(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public void addCoinForSale(long coinDescriptionId, BigDecimal cost, String userLogin) {
        Collection collection = collectionRepository.findCollectionByCoinDescriptionIdAndUserUserLogin(coinDescriptionId, userLogin);
        collection.setSale(SaleType.FORSALE);
        collection.setCost(cost);
        collectionRepository.save(collection);
    }
}
