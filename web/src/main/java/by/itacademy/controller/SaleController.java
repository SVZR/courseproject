package by.itacademy.controller;

import by.itacademy.entity.Collection;
import by.itacademy.entity.SaleType;
import by.itacademy.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author kirylhrybouski
 */
@Controller
public class SaleController extends BaseController {

    private CollectionService collectionService;

    @Autowired
    public SaleController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @ModelAttribute("collections")
    public List<Collection> getAllCollectionForSale() {
        return collectionService.getAllCollectionForSale();
    }

    @GetMapping("/sale")
    public String showSalePage() {
        return "sale";
    }

    @PostMapping("/notForSale")
    public String notForSale(long collectionId) {
        Collection collection = collectionService.getCollectionById(collectionId);
        collection.setSale(SaleType.NOTFORSALE);
        collectionService.saveChangedCollection(collection);
        return "redirect:/sale";
    }
}
