package by.itacademy.repository;

import by.itacademy.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
/**
 * @author kirylhrybouski
 */
@CacheConfig(cacheNames = "user")
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    @Cacheable
    User findUserByUserLogin(String userLogin);

    void deleteById(long id);
}
