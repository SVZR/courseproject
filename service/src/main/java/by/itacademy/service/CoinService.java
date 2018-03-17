package by.itacademy.service;

import by.itacademy.entity.Coin;

import java.util.List;

public interface CoinService {

    Coin getCoinInformationAndCoinDescriptions(long coinId);

    Coin getCoinById(long id);
}
