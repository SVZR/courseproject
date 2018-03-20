package by.itacademy.controller;

import by.itacademy.entity.News;
import by.itacademy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Locale;

/**
 * @author kirylhrybouski
 */
@Controller
public class IndexController extends BaseController {

    private NewsService newsService;

    @Autowired
    public IndexController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ModelAttribute("news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/index")
    public String showIndexPage(Locale locale) {
        System.out.println(locale);
        return "index";
    }
}
