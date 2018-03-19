package by.itacademy.dao;

import by.itacademy.config.TestPersistenceConfig;
import by.itacademy.entity.Role;
import by.itacademy.entity.Theme;
import by.itacademy.entity.User;
import by.itacademy.repository.ThemeRepository;
import by.itacademy.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestPersistenceConfig.class)
public class TestMethodsForUserEntity {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Test
    public void getAllCoinsByCountryId() {
        List<Theme> allByCountry_id = themeRepository.findAllByCountryId(1l);
        allByCountry_id.forEach(theme -> System.out.println(theme.getName()));
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");
        user.setUserLogin("TestUserLogin");
        user.setRole(Role.ADMINISTRATOR);
        user.setPassword("TestPassword");
        user.setEmail("test@test.by");

        User save = userRepository.save(user);

        assertTrue(save.getId() > 0);
    }

    @Test
    public void testUserDaoMethods() {

        List<User> all = (List<User>) userRepository.findAll();
        assertEquals(4, all.size());

        User byId = userRepository.findOne(1L);
        assertEquals("TestFirstNameOne", byId.getFirstName());
        byId.setUserLogin("Changed");

        Integer allUsersAmount = ((List<User>) userRepository.findAll()).size();
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
        User save = userRepository.save(userOne);

        List<User> all = (List<User>) userRepository.findAll();
        assertEquals(1, all.size());

        userRepository.delete(save);

        List<User> allNew = (List<User>) userRepository.findAll();
        assertEquals(0, allNew.size());
    }
}
