package by.itacademy.service;

import by.itacademy.entity.User;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getFilteredUsersOnPage(Map<String, String> searchFilter, int pageNumber, int amountOfUsersOnPage) {
        return userRepository.findFilteredUsersOnPage(searchFilter, (pageNumber - 1) * amountOfUsersOnPage, amountOfUsersOnPage);
    }

    public Map<Integer, Integer> getFilteredUsersAmount(Map<String, String> searchFilter, int amountUsersOnPage) {
        int result = userRepository.findFilteredUsersAmount(searchFilter);
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
