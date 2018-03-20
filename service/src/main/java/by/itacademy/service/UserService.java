package by.itacademy.service;

import by.itacademy.dto.SearchFilterTest;
import by.itacademy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
/**
 * @author kirylhrybouski
 */
public interface UserService extends UserDetailsService {

    List<User> getFilteredUsersOnPage(Map<String, String> searchFilter, int pageNumber, int amountOfUsersOnPage);

    Map<Integer, Integer> getFilteredUsersAmount(Map<String, String> searchFilter, int amountUsersOnPage);

    void saveUser(User user);

    void saveUserWithNewParams(User user);

    Map<Integer, Integer> getFilteredUsersAmountTest(SearchFilterTest searchFilterTest, int amountUsersOnPage);

    List<User> getFilteredUsersOnPageTest(SearchFilterTest searchFilterTest, int pageNumber, int amountOfUsersOnPage);

    User getUserInformation(String userLogin);

    void deleteUserByUserId(Long userId);
}
