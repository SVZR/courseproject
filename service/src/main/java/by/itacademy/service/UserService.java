package by.itacademy.service;

import by.itacademy.dao.UserDao;

public class UserService {
    public String getUsername() {
        return new UserDao().getUsername();
    }
}
