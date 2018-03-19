package by.itacademy.service;

import by.itacademy.dto.CatalogDto;
import by.itacademy.repository.CountryRepository;
import by.itacademy.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public CatalogDto getListOfCoins(long countryId) {
        CatalogDto catalogDto = new CatalogDto();
        catalogDto.setCountryName(countryRepository.findCountryById(countryId).getName());
        System.out.println(catalogDto.getCountryName());
        catalogDto.setThemes(themeRepository.findAllByCountryId(countryId));
        catalogDto.getThemes().forEach(theme -> System.out.println(theme.getName()));
        return catalogDto;
    }
}
