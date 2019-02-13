package by.itacademy.repository;

import by.itacademy.entity.Metal;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author kirylhrybouski
 */
public interface MetalRepository extends JpaRepository<Metal, Long> {
}
