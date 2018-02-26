package by.itacademy.service;

import by.itacademy.entity.Coin;

import java.util.List;

public interface CoinService {

    List<Coin> getAllCoinsByCountryId(long countryId);

    Coin getCoinById(long id);
}
