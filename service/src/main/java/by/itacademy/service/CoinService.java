package by.itacademy.service;

import by.itacademy.dao.CoinDao;
import by.itacademy.entity.Coin;

import java.util.List;

public final class CoinService {

    private static CoinService instance = null;

    private CoinService() {}

    public static CoinService getInstance() {
        if (instance == null) {
            synchronized (CoinService.class) {
                if (instance == null) {
                    instance = new CoinService();
                }
            }
        }
        return instance;
    }

    public List<Coin> getAllCoinsByCountryId(long countryId) {
        return new CoinDao().findCoinsByCountryId(countryId);
    }

    public Coin getCoinById(long id) {
        return new CoinDao().findById(id);
    }
}
