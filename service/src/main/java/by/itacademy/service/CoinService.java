package by.itacademy.service;

import by.itacademy.entity.Coin;

import java.util.Map;
/**
 * @author kirylhrybouski
 */
public interface CoinService {

    Coin getCoinInformationAndCoinDescriptions(long coinId);

    Coin getCoinById(long id);

    Map<Long, Long> getCollectionInfo(String userLogin, long coinId);

    Coin getCoinCollectionInformation(long coinId, String userLogin);
}
