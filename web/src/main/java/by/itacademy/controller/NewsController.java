package by.itacademy.controller;

import by.itacademy.entity.News;
import by.itacademy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ModelAttribute("news")
    public List<News> putAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/news")
    public String showNewsPage() {
        return "news";
    }
}
