package by.itacademy.controller;

import by.itacademy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String showCountryPage(Model model, @RequestParam("id") Long countryId) {
        System.out.println("Finding country id=" + countryId);
        model.addAttribute("country", countryService.getCountryById(countryId));
        return "country";
    }
}
