package by.itacademy.controller;

import by.itacademy.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kirylhrybouski
 */
@Controller
public class SearchController extends BaseController {

    private CoinService coinService;

    @Autowired
    public SearchController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/search")
    public String showSearchPage(Model model, @RequestParam("coinName") String coinName) {
        model.addAttribute("coins", coinService.getCoinsByPartName(coinName));
        return "search";
    }
}
