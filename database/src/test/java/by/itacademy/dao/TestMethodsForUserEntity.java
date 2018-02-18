package by.itacademy.dao;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestMethodsForUserEntity {

    private static UserDao USER_DAO = new UserDao();

    @Test
    public void testUserDaoMethods() {

        List<User> all = USER_DAO.findAll();
        assertEquals(4, all.size());

        User byId = USER_DAO.findById(1);
        assertEquals("TestFirstNameOne", byId.getFirstName());
        byId.setUserLogin("Changed");

        Integer allUsersAmount = USER_DAO.findAllUsersAmount();
        assertEquals(4, (long) allUsersAmount);

    }

    @Test
    public void deleteTest() {
        User userOne = new User();
        userOne.setFirstName("TestFirstNameFive");
        userOne.setUserLogin("TestLoginFive");
        userOne.setLastName("TestLastNameFive");
        userOne.setEmail("TestFive@test.by");
        userOne.setPassword("test");
        userOne.setRole(Role.USER);
        long save = USER_DAO.save(userOne);

        List<User> all = USER_DAO.findAll();
        assertEquals(5, all.size());

        USER_DAO.delete(save);

        List<User> allNew = USER_DAO.findAll();
        assertEquals(4, allNew.size());
    }

    @Test
    public void updateTest() {

        User user = USER_DAO.findById(1);
        user.setUserLogin("Changed");
        USER_DAO.update(user);

        User user1 = USER_DAO.findById(1);
        assertEquals("Changed", user1.getUserLogin());
    }
}
