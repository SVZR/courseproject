package by.itacademy.service;

import by.itacademy.entity.Coin;
import by.itacademy.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Override
    public List<Coin> getAllCoinsByCountryId(long countryId) {
        return coinRepository.findCoinsByCountryId(countryId);
    }

    @Override
    public Coin getCoinById(long id) {
        return coinRepository.findOne(id);
    }
}
