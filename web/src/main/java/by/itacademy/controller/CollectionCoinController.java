package by.itacademy.controller;

import by.itacademy.service.CoinService;
import by.itacademy.service.CollectionService;
import by.itacademy.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author kirylhrybouski
 */
@Controller
public class CollectionCoinController extends BaseController {

    private CoinService coinService;
    private CollectionService collectionService;
    private SaleService saleService;

    @Autowired
    public CollectionCoinController(CoinService coinService, CollectionService collectionService, SaleService saleService) {
        this.coinService = coinService;
        this.collectionService = collectionService;
        this.saleService = saleService;
    }

    @GetMapping("/collectionCoin")
    public String showCollectionCoinPage(Model model, @RequestParam("id") long id) {
        model.addAttribute("coinsInCollection", coinService.getCollectionInfo(getUserLogin(), id));
        model.addAttribute("coin", coinService.getCoinCollectionInformation(id, getUserLogin()));
        return "collectionCoin";
    }

    @PostMapping("/updateCoinAmount")
    public String updateCoinAmount(long amount, long coinDescriptionId, long coinId) {
        if (amount >= 0) {
            collectionService.updateAmountInCollection(coinDescriptionId, amount, getUserLogin());
        }
        return "redirect:/collectionCoin?id=" + coinId;
    }

    @PostMapping("/addCoinForSale")
    public String addCoinForSale(long coinDescriptionId, BigDecimal cost, long coinId) {
        saleService.addCoinForSale(coinDescriptionId, cost, getUserLogin());
        return "redirect:/collectionCoin?id=" + coinId;
    }
}
