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
public class EditCountryController extends BaseController {

    private CountryService countryService;

    @Autowired
    public EditCountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/edit-country")
    public String showEditPage(Model model) {
        Country country = countryService.getCountryForEdit(5L);
//        System.out.println("id: " + country.getId() + " country name -" + country.getName());
        model.addAttribute("country", country);
        return "edit-country";
    }

    @PostMapping("/edit-country")
    public String editCountry(Country country, Long countryId) {
        country.setId(countryId);
        System.out.println("id: " + country.getId() + " country name -" + country.getName());
        countryService.editCountry(country);
        return "redirect:/edit-country";
    }
}
