package by.itacademy.controller;

import by.itacademy.entity.News;
import by.itacademy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
/**
 * @author kirylhrybouski
 */
@Controller
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ModelAttribute("news")
    public List<News> putAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/news")
    public String showNewsPage() {
        return "news";
    }
}
