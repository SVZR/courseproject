package by.itacademy.service;

import by.itacademy.dto.CatalogDto;
/**
 * @author kirylhrybouski
 */
public interface CatalogService {

    CatalogDto getListOfCoins(long countryId);
}
