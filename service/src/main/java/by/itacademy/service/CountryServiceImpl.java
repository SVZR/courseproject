package by.itacademy.service;

import by.itacademy.entity.Country;
import by.itacademy.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long id) {
        return countryRepository.findCountryById(id);
    }
}

