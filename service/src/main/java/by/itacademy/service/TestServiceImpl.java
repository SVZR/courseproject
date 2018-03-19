package by.itacademy.service;

import by.itacademy.entity.Coin;
import by.itacademy.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private CoinRepository coinRepository;

    @Override
    public List<Coin> getAllCoinsByCountryId(long countryId) {
        return coinRepository.findCoinsByCountryId(countryId);
    }
}
