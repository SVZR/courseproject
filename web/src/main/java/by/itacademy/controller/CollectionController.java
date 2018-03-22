package by.itacademy.controller;

import by.itacademy.entity.Country;
import by.itacademy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
/**
 * @author kirylhrybouski
 */
@Controller
public class CollectionController extends BaseController {

    private CountryService countryService;

    @Autowired
    public CollectionController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ModelAttribute("countryNames")
    public List<Country> getCountryNames() {
        return countryService.getCountriesForCollection(getUserLogin());
    }

    @GetMapping("/collection")
    public String showCollectionPage() {
        return "collection";
    }
}
