package by.itacademy.controller;

import by.itacademy.entity.Country;
import by.itacademy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Component
public class BaseController {

    @Autowired
    private CountryService countryService;

    @ModelAttribute("allCountries")
    public List<Country> allCountries() {
        return countryService.getAllCountries();
    }
}
