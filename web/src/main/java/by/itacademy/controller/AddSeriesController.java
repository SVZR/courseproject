package by.itacademy.controller;

import by.itacademy.dto.SaveSeriesDto;
import by.itacademy.entity.Theme;
import by.itacademy.service.SeriesService;
import by.itacademy.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author kirylhrybouski
 */
@Controller
public class AddSeriesController extends BaseController {

    private ThemeService themeService;
    private SeriesService seriesService;

    @Autowired
    public AddSeriesController(ThemeService themeService, SeriesService seriesService) {
        this.themeService = themeService;
        this.seriesService = seriesService;
    }

    @ModelAttribute("themes")
    public List<Theme> getAllThemes() {
        return themeService.getAllThemes();
    }

    @GetMapping("/add-series")
    public String showAddSeriesPage(Model model) {
        model.addAttribute("newSeries", new SaveSeriesDto());
        return "add-series";
    }

    @PostMapping("/addSeries")
    public String createNewSeries(@ModelAttribute("newTheme") SaveSeriesDto newSeries) {
        seriesService.createNewSeries(newSeries);
        return "redirect:/add-series";
    }
}
