package by.itacademy.controller;

import by.itacademy.entity.Country;
import by.itacademy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/catalog")
    public String showCatalogPage() {
        return "catalog";
    }
}
