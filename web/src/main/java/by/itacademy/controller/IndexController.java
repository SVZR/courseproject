package by.itacademy.controller;

import by.itacademy.entity.Country;
import by.itacademy.entity.News;
import by.itacademy.service.CountryService;
import by.itacademy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private NewsService newsService;

    @ModelAttribute("news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @ModelAttribute("allCountries")
    public List<Country> allCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }
}
