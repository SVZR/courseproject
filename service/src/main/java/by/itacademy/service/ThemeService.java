package by.itacademy.service;

import by.itacademy.dto.SaveThemeDto;
import by.itacademy.entity.Theme;

import java.util.List;

/**
 * @author kirylhrybouski
 */
public interface ThemeService {

    List<Theme> getAllThemes();

    void createNewTheme(SaveThemeDto theme);

    Theme getTestTheme();

    void testSave(Theme theme);
}
