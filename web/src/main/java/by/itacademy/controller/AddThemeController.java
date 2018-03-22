package by.itacademy.controller;

import by.itacademy.dto.SaveThemeDto;
import by.itacademy.entity.Country;
import by.itacademy.service.CountryService;
import by.itacademy.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author kirylhrybouski
 */
@Controller
public class AddThemeController extends BaseController {

    private CountryService countryService;
    private ThemeService themeService;

    @Autowired
    public AddThemeController(CountryService countryService, ThemeService themeService) {
        this.countryService = countryService;
        this.themeService = themeService;
    }

    @ModelAttribute("countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/add-theme")
    public String showAddThemePage(Model model) {
        model.addAttribute("newTheme", new SaveThemeDto());
        return "add-theme";
    }

    @PostMapping("/addTheme")
    public String createNewTheme(@ModelAttribute("newTheme") SaveThemeDto newTheme) {
        themeService.createNewTheme(newTheme);
        return "redirect:/add-theme";
    }

    @PostMapping("/button")
    public String button() {
        System.out.println("Button");
        return "redirect:/add-theme";
    }
}
