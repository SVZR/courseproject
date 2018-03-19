package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "metal")
public class Metal extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "metal")
    private Set<CoinDescription> coinDescriptions = new HashSet<>();
}
