package by.itacademy.service;

import by.itacademy.dao.ThemeDao;
import by.itacademy.entity.Theme;

import java.util.List;

public final class ThemeService {

    private static ThemeService instance = null;

    private ThemeService() {}

    public static ThemeService getInstance() {
        if (instance == null) {
            synchronized (ThemeService.class) {
                if (instance == null) {
                    instance = new ThemeService();
                }
            }
        }
        return instance;
    }

    public List<Theme> getAllThemesByCountryId(long countryId) {
        return new ThemeDao().findAllThemesByCountry(countryId);
    }
}
