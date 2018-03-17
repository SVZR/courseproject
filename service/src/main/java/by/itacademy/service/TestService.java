package by.itacademy.service;

import by.itacademy.entity.Coin;

import java.util.List;

public interface TestService {

    List<Coin> getAllCoinsByCountryId(long countryId);
}
