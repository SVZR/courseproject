package by.itacademy.service;

import by.itacademy.dao.CountryDao;
import by.itacademy.dto.CountryDto;

import java.util.List;
import java.util.stream.Collectors;

public final class CountryService {

    private static CountryService instance = null;

    private CountryService() {}

    public static CountryService getInstance() {
        if (instance == null) {
            synchronized (CountryService.class) {
                if (instance == null) {
                    instance = new CountryService();
                }
            }
        }
        return instance;
    }

    public List<CountryDto> getAllCountries() {
        return CountryDao.getInstance().findAll()
                .stream()
                .map(country -> new CountryDto(country.getName()))
                .collect(Collectors.toList());
    }
}
