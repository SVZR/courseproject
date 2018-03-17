package by.itacademy.controller;

import by.itacademy.entity.Role;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ModelAttribute("roles")
    public Role[] getAllRoles() {
        return Role.values();
    }

    @ModelAttribute("amountUsers")
    public List<String> getAmount() {
        return Arrays.asList("2", "4", "6", "8");
    }

    @GetMapping(value = "/users")
    public String showUserPage(Model model, HttpServletRequest req) {

        Map<String, String> searchFilter = new HashMap<>();
        if (req.getParameter("firstName") != null && !req.getParameter("firstName").isEmpty()) {
            searchFilter.put("firstName", req.getParameter("firstName"));
        }
        if (req.getParameter("role") != null && !req.getParameter("role").isEmpty() && !req.getParameter("role").equals("ALL")) {
            searchFilter.put("role", req.getParameter("role"));
        }
        if (req.getParameter("haveCollection") != null && !req.getParameter("haveCollection").isEmpty()) {
            searchFilter.put("haveCollection", req.getParameter("haveCollection"));
        }
        if (req.getParameter("amountUsersOnPage") != null && !req.getParameter("amountUsersOnPage").isEmpty()) {
            searchFilter.put("amountUsersOnPage", req.getParameter("amountUsersOnPage"));
        }

        model.addAttribute("searchFilter", searchFilter);

        int page = req.getParameterMap()
                .containsKey("page") ? Integer.valueOf(req.getParameter("page")) : 1;
        int amountUsersOnPage = req.getParameterMap()
                .containsKey("amountUsersOnPage") ? Integer.valueOf(req.getParameter("amountUsersOnPage")) : 2;

        model.addAttribute("users", userService.getFilteredUsersOnPage(searchFilter, page, amountUsersOnPage));
        model.addAttribute("pages", userService.getFilteredUsersAmount(searchFilter, amountUsersOnPage).keySet());
        return "users";
    }
}
