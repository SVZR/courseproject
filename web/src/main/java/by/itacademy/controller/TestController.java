package by.itacademy.controller;

import by.itacademy.dto.CatalogDto;
import by.itacademy.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController extends BaseController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/test")
    public String showTestPage(Model model) {
        CatalogDto listOfCoins = catalogService.getListOfCoins(1L);
        model.addAttribute("countryName", listOfCoins.getCountryName());
        model.addAttribute("themes", listOfCoins.getThemes());
        System.out.println("Show test page");
        return "test";
    }
}
