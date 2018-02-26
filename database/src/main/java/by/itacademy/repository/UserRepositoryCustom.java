package by.itacademy.repository;

import by.itacademy.entity.User;

import java.util.List;
import java.util.Map;

public interface UserRepositoryCustom {

    Integer findFilteredUsersAmount(Map<String, String> searchFilter);

    List<User> findFilteredUsersOnPage(Map<String, String> searchFilter, int firstUserNumber, int amountUsersOnPage);


}
