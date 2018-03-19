package by.itacademy.controller;

import by.itacademy.service.CatalogService;
import by.itacademy.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author kirylhrybouski
 */
@Controller
public class TestController extends BaseController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private CoinService coinService;

    @GetMapping("/test")
    public String showTestPage(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        List<String> authorities = authentication
//                .getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//        String authenticationName = authentication.getName();
//        List<Collection> collectionInfo = coinService.getCollectionInfo(authenticationName, 2);
//        collectionInfo.stream()
//                .peek(col -> System.out.println(col.getAmount()))
//                .forEach(col -> System.out.println(col.getCoinDescription().getId()));
//
//        System.out.println(authentication.getName());
//        if (authorities.contains("MODERATOR")) {
//            System.out.println("User is MODERATOR");
//        } else if (authorities.contains("ADMINISTRATOR")) {
//            System.out.println("User is ADMINISTRATOR");
//        } else if (authorities.contains("USER")) {
//            System.out.println("User is USER");
//        } else {
//            System.out.println("User is USER_ANON");
//        }
        return "test";
    }
}
