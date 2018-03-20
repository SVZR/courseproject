package by.itacademy.service;

import by.itacademy.entity.Coin;
import by.itacademy.entity.Collection;
import by.itacademy.repository.CoinRepository;
import by.itacademy.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class CoinServiceImpl implements CoinService {

    private CoinRepository coinRepository;

    private CollectionRepository collectionRepository;

    @Autowired
    public CoinServiceImpl(CoinRepository coinRepository, CollectionRepository collectionRepository) {
        this.coinRepository = coinRepository;
        this.collectionRepository = collectionRepository;
    }

    @Override
    public Coin getCoinInformationAndCoinDescriptions(long coinId) {
            return coinRepository.findCoinByIdFetchedCoinDescription(coinId);
    }

    @Override
    public Map<Long, Long> getCollectionInfo(String userLogin, long coinId) {
        List<Collection> collections = collectionRepository.findAllByCoinDescriptionCoinIdAndUserUserLogin(coinId, userLogin);
        Map<Long, Long> map = new HashMap<>();
        collections.forEach(col -> map.put(col.getCoinDescription().getId(), col.getAmount()));
        return map;
    }

    @Override
    public Coin getCoinCollectionInformation(long coinId, String userLogin) {
        return coinRepository.findCoinByIdAndUserLoginInCollection(coinId, userLogin);
    }

    @Override
    public List<Coin> getCoinsByPartName(String coinName) {
        return coinRepository.findCoinsByNameLike("%" + coinName + "%");
    }


}
