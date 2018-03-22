package by.itacademy.controller;

import by.itacademy.entity.Theme;
import by.itacademy.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author kirylhrybouski
 */
@Controller
@SessionAttributes(names = "theme")
public class EditThemeController extends BaseController {

    private ThemeService themeService;

    @Autowired
    public EditThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/edit-theme")
    public String showEditPage(Model model) {
        Theme theme = themeService.getTestTheme();
//        System.out.println("id: " + country.getId() + " country name -" + country.getName());
        model.addAttribute("theme", theme);
        return "edit-theme";
    }

    @PostMapping("/edit-theme")
    public String editCountry(String themeName, Model model) {
        System.out.println(themeName);
        System.out.println(model.asMap().containsKey("theme"));
        Theme theme = (Theme) model.asMap().get("theme");
        System.out.println("themeId=" + theme.getId());
        theme.setName(themeName);
        try {
            themeService.testSave(theme);
        } catch (Exception e) {
            return "optimisticLock";
        }
        return "redirect:/edit-theme";
    }

    @GetMapping("/optimistickLock")
    public String showLockPage() {
        return "optimisticLock";
    }
}
