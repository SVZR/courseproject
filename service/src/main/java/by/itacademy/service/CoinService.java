package by.itacademy.service;

import by.itacademy.dto.SaveCoinDto;
import by.itacademy.entity.Coin;

import java.util.List;
import java.util.Map;
/**
 * @author kirylhrybouski
 */
public interface CoinService {

    Coin getCoinInformationAndCoinDescriptions(long coinId);

    Map<Long, Long> getCollectionInfo(String userLogin, long coinId);

    Coin getCoinCollectionInformation(long coinId, String userLogin);

    List<Coin> getCoinsByPartName(String coinName);

    void createNewCoin(SaveCoinDto coin);
}
