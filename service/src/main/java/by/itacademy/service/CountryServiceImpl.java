package by.itacademy.service;

import by.itacademy.entity.Country;
import by.itacademy.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;
/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, EntityManagerFactory entityManagerFactory) {
        this.countryRepository = countryRepository;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    @Cacheable(cacheNames = "countries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long id) {
        return countryRepository.findCountryByIdFetchedTillCoin(id);
    }

    @Override
    public List<Country> getCountriesForCollection(String userLogin) {
        return countryRepository.findCountriesByUserLoginCollection(userLogin);
    }

    @Override
    public Country getCountryForCollection(long countryId, String userLogin) {
        return countryRepository.findCountryByIdAndUserLoginFetchedTillCoin(countryId, userLogin);
    }

    @Override
    public void createNewCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void editCountry(Country country) {
//        entityManagerFactory.createEntityManager().merge(country);
        countryRepository.save(country);
    }

    @Override
    public Country getCountryForEdit(long id) {
        return countryRepository.getCountryById(id);
    }
}

