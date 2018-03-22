package by.itacademy.controller;

import by.itacademy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author kirylhrybouski
 */
@Controller
public class CollectionCountryController extends BaseController {

    private CountryService countryService;

    @Autowired
    public CollectionCountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/collectionCountry")
    public String showCountryCollectionPage(Model model, @RequestParam("countryId") long countryId) {
        model.addAttribute("country", countryService.getCountryForCollection(countryId, getUserLogin()));
        return "collectionCountry";
    }
}
