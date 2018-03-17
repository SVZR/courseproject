package by.itacademy.service;

import by.itacademy.dto.CatalogDto;

public interface CatalogService {

    CatalogDto getListOfCoins(long countryId);
}
