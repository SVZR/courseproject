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
public class CollectionCoinController extends BaseController {

    private CoinService coinService;

    @Autowired
    public CollectionCoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/collectionCoin")
    public String showCollectionCoinPage(Model model, @RequestParam("id") long id) {
        model.addAttribute("coinsInCollection", coinService.getCollectionInfo(getUserLogin(), id));
        model.addAttribute("coin", coinService.getCoinCollectionInformation(id, getUserLogin()));
        return "collectionCoin";
    }
}
