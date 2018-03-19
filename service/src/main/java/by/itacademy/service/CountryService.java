package by.itacademy.service;

import by.itacademy.entity.Country;

import java.util.List;
/**
 * @author kirylhrybouski
 */
public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryById(long id);

    List<Country> getCountriesForCollection(String userLogin);

    Country getCountryForCollection(long countryId, String userLogin);
}
