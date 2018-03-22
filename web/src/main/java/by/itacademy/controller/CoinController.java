package by.itacademy.controller;

import by.itacademy.service.CoinService;
import by.itacademy.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author kirylhrybouski
 */
@Controller
public class CoinController extends BaseController {

    private CoinService coinService;

    private CollectionService collectionService;

    @Autowired
    public CoinController(CoinService coinService, CollectionService collectionService) {
        this.coinService = coinService;
        this.collectionService = collectionService;
    }

    @GetMapping("/coin")
    public String showCoinPage(Model model, @RequestParam("id") long coinId) {
        model.addAttribute("coinsInCollection", coinService.getCollectionInfo(getUserLogin(), coinId));
        model.addAttribute("coin", coinService.getCoinInformationAndCoinDescriptions(coinId));
        return "coin";
    }

    @PostMapping("/updateCoinAmountCol")
    public String updateCoinAmount(long amount, long coinDescriptionId, long coinId) {
        if (amount >= 0) {
            collectionService.updateAmountInCollection(coinDescriptionId, amount, getUserLogin());
        }
        return "redirect:/coin?id=" + coinId;
    }

    @PostMapping("/addCoinAmount")
    public String saveCoinAmount(long amount, long coinDescriptionId, long coinId) {
        collectionService.saveAmountInCollection(coinDescriptionId, amount, getUserLogin());
        return "redirect:/coin?id=" + coinId;
    }
}
