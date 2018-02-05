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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country")
    private Set<Theme> themes = new HashSet<>();
}
