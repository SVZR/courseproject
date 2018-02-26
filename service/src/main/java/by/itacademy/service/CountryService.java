package by.itacademy.service;

import by.itacademy.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryById(long id);

}
