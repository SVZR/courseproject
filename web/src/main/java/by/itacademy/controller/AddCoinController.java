package by.itacademy.controller;

import by.itacademy.dto.SaveCoinDto;
import by.itacademy.entity.Series;
import by.itacademy.service.CoinService;
import by.itacademy.service.SeriesService;
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
public class AddCoinController extends BaseController {

    private SeriesService seriesService;
    private CoinService coinService;

    @Autowired
    public AddCoinController(SeriesService seriesService, CoinService coinService) {
        this.seriesService = seriesService;
        this.coinService = coinService;
    }

    @ModelAttribute("allSeries")
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    @GetMapping("/add-coin")
    public String showAddCoinPage(Model model) {
        model.addAttribute("newCoin", new SaveCoinDto());
        return "add-coin";
    }

    @PostMapping("/add-coin")
    public String createNewCoin(@ModelAttribute("newCoin") SaveCoinDto newCoin) {
        coinService.createNewCoin(newCoin);
        return "redirect:/add-coin";
    }
}
