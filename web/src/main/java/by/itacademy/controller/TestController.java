package by.itacademy.controller;

import by.itacademy.dto.SearchFilterTest;
import by.itacademy.entity.Role;
import by.itacademy.service.CoinService;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

/**
 * @author kirylhrybouski
 */
@Controller
public class TestController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    @ModelAttribute("roles")
    public Role[] getAllRoles() {
        return Role.values();
    }

    @ModelAttribute("amountUsers")
    public List<String> getAmount() {
        return Arrays.asList("2", "4", "6", "8");
    }

    @GetMapping("/test")
    public String showTestPage(Model model, SearchFilterTest searchFilterTest, Integer page, Integer amountUsersOnPage) {

//        if (!model.containsAttribute("searchFilterTest")) {
//            SearchFilterTest newSearchFilterTest = new SearchFilterTest();
//            newSearchFilterTest.setRole("ALL");
//            model.addAttribute("searchFilterTest", newSearchFilterTest);
//        } else {
//            model.addAttribute("searchFilterTest", searchFilterTest);
//        }
        System.out.println(searchFilterTest);

        SearchFilterTest searchFilterTest1 = new SearchFilterTest();
        searchFilterTest1.setRole("");
        searchFilterTest1.setFirstName("");
        searchFilterTest1.setHaveCollection("");
        searchFilterTest1.setAmountUsersOnPage(2);

        System.out.println(searchFilterTest1);

//        searchFilterTest1.setRole(!searchFilterTest.getRole().equals("null") ? searchFilterTest.getRole() : "ALL");
//        searchFilterTest1.setFirstName(!searchFilterTest.getFirstName().equals("null") ? searchFilterTest.getFirstName() : "");
//        searchFilterTest1.setHaveCollection(!searchFilterTest.getHaveCollection().equals("null") ? searchFilterTest.getHaveCollection() : "");
//        searchFilterTest1.setAmountUsersOnPage(searchFilterTest.getAmountUsersOnPage() != null ? searchFilterTest.getAmountUsersOnPage() : 2);

        int pageNumber = model.containsAttribute("page") ? page : 1;
//        int amountUsersOnPageNumber = model.containsAttribute("amountUsersOnPage") && amountUsersOnPage != null ? amountUsersOnPage : 2;

        System.out.println(searchFilterTest);

        model.addAttribute("users", userService.getFilteredUsersOnPageTest(searchFilterTest1, pageNumber, searchFilterTest1.getAmountUsersOnPage()));
        model.addAttribute("pages", userService.getFilteredUsersAmountTest(searchFilterTest1, searchFilterTest1.getAmountUsersOnPage()).keySet());

        return "test";
    }
}
