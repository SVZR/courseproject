package by.itacademy.controller;

import by.itacademy.entity.Country;
import by.itacademy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author kirylhrybouski
 */
@Controller
public class AddCountryController extends BaseController {

    private CountryService countryService;

    @Autowired
    public AddCountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/add-country")
    public String showAddCountryPage(Model model) {
        model.addAttribute("newCountry", new Country());
        return "add-country";
    }

    @PostMapping("/add-country")
    public String addNewCountry(Country country) {
        countryService.createNewCountry(country);
        return "redirect:/add-country";
    }
}
