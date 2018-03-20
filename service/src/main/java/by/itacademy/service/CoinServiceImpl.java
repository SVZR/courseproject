package by.itacademy.service;

import by.itacademy.dto.SaveCoinDto;
import by.itacademy.entity.Coin;
import by.itacademy.entity.Collection;
import by.itacademy.entity.Series;
import by.itacademy.repository.CoinRepository;
import by.itacademy.repository.CollectionRepository;
import by.itacademy.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private SeriesRepository seriesRepository;

    @Autowired
    public CoinServiceImpl(CoinRepository coinRepository, CollectionRepository collectionRepository, SeriesRepository seriesRepository) {
        this.coinRepository = coinRepository;
        this.collectionRepository = collectionRepository;
        this.seriesRepository = seriesRepository;
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

    @Override
    public void createNewCoin(SaveCoinDto coin) {
        Series one = seriesRepository.findOne(coin.getSeriesId());
        Coin saveCoin = new Coin();
        saveCoin.setSeries(one);
        saveCoin.setName(coin.getCoinName());
        saveCoin.setDescription(coin.getDescription());
        saveCoin.setDesigner(coin.getDesigner());
        saveCoin.setMintedBy(coin.getMintedBy());
        saveCoin.setReleaseDate(LocalDate.parse(coin.getReleaseDate()));
        coinRepository.save(saveCoin);
    }


}
