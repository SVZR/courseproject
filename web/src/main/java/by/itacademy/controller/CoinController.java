package by.itacademy.controller;

import by.itacademy.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoinController extends BaseController {

    @Autowired
    private CoinService coinService;

    @GetMapping("/coin")
    public String showCoinPage(Model model, @RequestParam("id") long coinId) {
        model.addAttribute("coin", coinService.getCoinInformationAndCoinDescriptions(coinId));
        return "coin";
    }
}
