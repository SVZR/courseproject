package by.itacademy.service;

import by.itacademy.dto.SaveThemeDto;
import by.itacademy.entity.Country;
import by.itacademy.entity.Theme;
import by.itacademy.repository.CountryRepository;
import by.itacademy.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {

    private ThemeRepository themeRepository;
    private CountryRepository countryRepository;

    @Autowired
    public ThemeServiceImpl(ThemeRepository themeRepository, CountryRepository countryRepository) {
        this.themeRepository = themeRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    @Override
    public void createNewTheme(SaveThemeDto theme) {
        Country country = countryRepository.findOne(theme.getCountryId());
        Theme savingTheme = new Theme();
        savingTheme.setCountry(country);
        savingTheme.setName(theme.getThemeName());
        themeRepository.save(savingTheme);
    }
}
