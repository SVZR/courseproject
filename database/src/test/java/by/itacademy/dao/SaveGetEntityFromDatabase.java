package by.itacademy.dao;

import by.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.hasSize;


public class SaveGetEntityFromDatabase {

    private SessionFactory sessionFactory;

    @Before
    public void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testSaveAndGetCountry() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country();
        country.setName("Republic of Lithuania");

        session.save(country);

        List<Country> countries = session.createQuery("select c from Country c", Country.class).getResultList();
        List<String> countryNames = countries.stream().map(Country::getName).collect(Collectors.toList());
        assertThat(countries, hasSize(1));
        assertThat(countryNames, containsInAnyOrder("Republic of Lithuania"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveAndGetTheme() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Theme theme = new Theme();
        theme.setName("Testname for theme");
        Country country = new Country("Republic of test");
        theme.setCountry(country);
        session.save(country);
        session.save(theme);

        List<Theme> themes = session.createQuery("select t from Theme t", Theme.class).getResultList();
        List<String> themeNames = themes.stream().map(Theme::getName).collect(Collectors.toList());
        assertThat(themes, hasSize(1));
        assertThat(themeNames, containsInAnyOrder("Testname for theme"));
        assertThat(themes.get(0).getCountry().getName(), equalTo("Republic of test"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveAndGetSeries() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Series series = new Series();
        series.setName("Test name for series");
        Theme theme = new Theme();
        theme.setName("Testname for theme");
        Country country = new Country("Republic of test");
        theme.setCountry(country);
        series.setTheme(theme);
        session.save(country);
        session.save(theme);
        session.save(series);

        List<Series> seriesList = session.createQuery("select s from Series s", Series.class).getResultList();
        List<String> seriesNames = seriesList.stream().map(Series::getName).collect(Collectors.toList());
        assertThat(seriesList, hasSize(1));
        assertThat(seriesNames, containsInAnyOrder("Test name for series"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveAndGetCoins() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Coin coin = new Coin();
        coin.setName("test name");
        coin.setDescription("test description");
        coin.setDesigner("test designer");
        coin.setImageAddress(new ImageAddress("test ImageAddress"));
        coin.setMintedBy("test mint");
        coin.setReleaseDate(LocalDate.now());
        Series series = new Series();
        series.setName("Test name for series");
        Theme theme = new Theme();
        theme.setName("Testname for theme");
        Country country = new Country("Republic of test");
        theme.setCountry(country);
        series.setTheme(theme);
        coin.setSeries(series);
        session.save(country);
        session.save(theme);
        session.save(series);
        session.save(coin);

        List<Coin> coinsList = session.createQuery("select c from Coin c", Coin.class).getResultList();
        List<String> coinsNames = coinsList.stream().map(Coin::getName).collect(Collectors.toList());
        assertThat(coinsList, hasSize(1));
        assertThat(coinsNames, containsInAnyOrder("test name"));

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testSaveAndGetCoinDescriptionAndMetal() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CoinDescription coinDescription = new CoinDescription();
        coinDescription.setDenomination(1200);
        coinDescription.setDiameter(1.2);
        coinDescription.setWeight(1.2);
        coinDescription.setMintage(1200);
        Metal metal = new Metal();
        metal.setName("test metal");
        coinDescription.setMetal(metal);
        session.save(metal);
        coinDescription.setImageObverse(new ImageAddress("test imageAddress1"));
        coinDescription.setImageReverse(new ImageAddress("test imageAddress2"));
        Coin coin = new Coin();
        coin.setName("test name");
        coin.setDescription("test description");
        coin.setDesigner("test designer");
        coin.setImageAddress(new ImageAddress("test ImageAddress"));
        coin.setMintedBy("test mint");
        coin.setReleaseDate(LocalDate.now());
        Series series = new Series();
        series.setName("Test name for series");
        Theme theme = new Theme();
        theme.setName("Testname for theme");
        Country country = new Country("Republic of test");
        theme.setCountry(country);
        series.setTheme(theme);
        coin.setSeries(series);
        coinDescription.setCoin(coin);
        session.save(country);
        session.save(theme);
        session.save(series);
        session.save(coin);
        session.save(coinDescription);

        List<CoinDescription> coinDescriptionsList = session.createQuery("select c from CoinDescription c", CoinDescription.class).getResultList();
        List<String> metalNames = coinDescriptionsList.stream().map(CoinDescription::getMetal).map(Metal::getName).collect(Collectors.toList());
        assertThat(coinDescriptionsList, hasSize(1));
        assertThat(metalNames, containsInAnyOrder("test metal"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveAndGetCollectionAndUser() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("test username");
        user.setEmail("test email");
        user.setPassword("test password");
        user.setRole(Role.USER);
        session.save(user);
        Collection collection = new Collection();
        collection.setAmount(3);
        CoinDescription coinDescription = new CoinDescription();
        coinDescription.setDenomination(1200);
        coinDescription.setDiameter(1.2);
        coinDescription.setWeight(1.2);
        coinDescription.setMintage(1200);
        Metal metal = new Metal();
        metal.setName("test metal");
        coinDescription.setMetal(metal);
        session.save(metal);
        coinDescription.setImageObverse(new ImageAddress("test imageAddress1"));
        coinDescription.setImageReverse(new ImageAddress("test imageAddress2"));
        Coin coin = new Coin();
        coin.setName("test name");
        coin.setDescription("test description");
        coin.setDesigner("test designer");
        coin.setImageAddress(new ImageAddress("test ImageAddress"));
        coin.setMintedBy("test mint");
        coin.setReleaseDate(LocalDate.now());
        Series series = new Series();
        series.setName("Test name for series");
        Theme theme = new Theme();
        theme.setName("Testname for theme");
        Country country = new Country("Republic of test");
        theme.setCountry(country);
        series.setTheme(theme);
        coin.setSeries(series);
        coinDescription.setCoin(coin);
        collection.setUser(user);
        collection.setCoinDescription(coinDescription);
        session.save(country);
        session.save(theme);
        session.save(series);
        session.save(coin);
        session.save(coinDescription);
        session.save(collection);

        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        List<Collection> collectionList = session.createQuery("select c from Collection c", Collection.class).getResultList();
        List<Long> collectionAmountList = collectionList.stream().map(Collection::getAmount).collect(Collectors.toList());
        assertThat(users, hasSize(1));
        assertThat(collectionList, hasSize(1));
        assertThat(collectionAmountList.get(0), equalTo(3L));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveAndGetSale() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Sale sale = new Sale();
        sale.setCost(BigDecimal.valueOf(1300));
        User user = new User();
        user.setUsername("test username");
        user.setEmail("test email");
        user.setPassword("test password");
        user.setRole(Role.USER);
        session.save(user);
        Collection collection = new Collection();
        collection.setAmount(3);
        CoinDescription coinDescription = new CoinDescription();
        coinDescription.setDenomination(1200);
        coinDescription.setDiameter(1.2);
        coinDescription.setWeight(1.2);
        coinDescription.setMintage(1200);
        Metal metal = new Metal();
        metal.setName("test metal");
        coinDescription.setMetal(metal);
        session.save(metal);
        coinDescription.setImageObverse(new ImageAddress("test imageAddress1"));
        coinDescription.setImageReverse(new ImageAddress("test imageAddress2"));
        Coin coin = new Coin();
        coin.setName("test name");
        coin.setDescription("test description");
        coin.setDesigner("test designer");
        coin.setImageAddress(new ImageAddress("test ImageAddress"));
        coin.setMintedBy("test mint");
        coin.setReleaseDate(LocalDate.now());
        Series series = new Series();
        series.setName("Test name for series");
        Theme theme = new Theme();
        theme.setName("Testname for theme");
        Country country = new Country("Republic of test");
        theme.setCountry(country);
        series.setTheme(theme);
        coin.setSeries(series);
        coinDescription.setCoin(coin);
        collection.setUser(user);
        collection.setCoinDescription(coinDescription);
        sale.setCollection(collection);
        session.save(country);
        session.save(theme);
        session.save(series);
        session.save(coin);
        session.save(coinDescription);
        session.save(collection);
        session.save(sale);

        List<Sale> sales = session.createQuery("select s from Sale s", Sale.class).getResultList();
        List<BigDecimal> salesCosts = sales.stream().map(Sale::getCost).collect(Collectors.toList());
        assertThat(sales, hasSize(1));
        assertThat(salesCosts, hasSize(1));
        assertThat(salesCosts.get(0), equalTo(BigDecimal.valueOf(1300)));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
