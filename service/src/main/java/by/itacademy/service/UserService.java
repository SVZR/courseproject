package by.itacademy.service;

import by.itacademy.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getFilteredUsersOnPage(Map<String, String> searchFilter, int pageNumber, int amountOfUsersOnPage);

    Map<Integer, Integer> getFilteredUsersAmount(Map<String, String> searchFilter, int amountUsersOnPage);
}
