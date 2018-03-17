package by.itacademy;

import by.itacademy.config.PersistenceConfig;
import by.itacademy.entity.Coin;
import by.itacademy.entity.Country;
import by.itacademy.repository.CoinRepository;
import by.itacademy.repository.CountryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.List;

public class demo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);
        System.out.println(context.isRunning());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
//        CoinRepository coinRepository = (CoinRepository) context.getBean("coinRepository");
//        List<Coin> something = coinRepository.findSomething(1L);
//        System.out.println(something.get(0).getSeries().getTheme().getCountry().getName());

//        CountryRepository countryRepository = (CountryRepository) context.getBean("countryRepository");
//        Country countryById = countryRepository.findSomething(1L);
//        countryById.getThemes().forEach(theme -> System.out.println(theme.getName()));
//        countryById.getThemes().iterator().next().getSeries().forEach(series -> System.out.println(series.getName()));
    }
}
