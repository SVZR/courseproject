package by.itacademy.controller;

import by.itacademy.dto.SaveCoinDto;
import by.itacademy.entity.Series;
import by.itacademy.exceptions.ValidationException;
import by.itacademy.service.CoinService;
import by.itacademy.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public String createNewCoin(@ModelAttribute("newCoin") @Validated SaveCoinDto newCoin, Error error) {
        System.out.println(new ValidationException(error.getMessage()).getLocalizedMessage());
        coinService.createNewCoin(newCoin);
        return "redirect:/add-coin";
    }

    @PostMapping("/addPicture")
    public String getPicture(@RequestPart MultipartFile picture) throws IOException {
        picture.transferTo(new File("Pictures"));
        return "index";
    }


    //todo вынести в другой пакет типа exceptionHandler с анотацией controllerAdvice
    @ExceptionHandler(ValidationException.class)
    public String catchingValidationException(ValidationException ex) {
        System.out.println(ex.getLocalizedMessage());
        return "index";
    }

    //todo посмотреть эти приколюхи
    @InitBinder("coin")
    public void validation(WebDataBinder webDataBinder) {
        webDataBinder.addValidators();
    }

}
