package by.itacademy.service;

import by.itacademy.dao.UserDao;
import by.itacademy.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UserService {

    private static UserService instance = null;

    private UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    public String getUsername() {
        return new UserDao().findById(1).getFirstName();
    }

    public List<User> getUsersOnPage(int pageNumber, int amountUsersOnPage) {
        return new UserDao().findAllUsersOnPage((pageNumber - 1) * amountUsersOnPage, amountUsersOnPage);
    }

    public List<User> getFilteredUsersOnPage(Map<String, String> searchFilter, int pageNumber, int amountOfUsersOnPage) {
        return new UserDao().findFilteredUsersOnPage(searchFilter, (pageNumber - 1) * amountOfUsersOnPage, amountOfUsersOnPage);
    }

    public Map<Integer, Integer> getUsersPagesAmount(int amountUsersOnPage) {

        int result = new UserDao().findAllUsersAmount();
        long pageNumbers;

        if (result % amountUsersOnPage > 0) {
            pageNumbers = result / amountUsersOnPage + 1;
        } else {
            pageNumbers = result / amountUsersOnPage;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= pageNumbers; i++) {
            map.put(i, (i - 1) * amountUsersOnPage);
        }
        return map;
    }

    public Map<Integer, Integer> getFilteredUsersAmount(Map<String, String> searchFilter, int amountUsersOnPage) {
        int result = new UserDao().findFilteredUsersAmount(searchFilter);
        long pageNumbers;

        if (result % amountUsersOnPage > 0) {
            pageNumbers = result / amountUsersOnPage + 1;
        } else {
            pageNumbers = result / amountUsersOnPage;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= pageNumbers; i++) {
            map.put(i, (i - 1) * amountUsersOnPage);
        }
        return map;
    }
}
