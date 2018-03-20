package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.HashSet;
import java.util.Set;
/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Version
    @Column(name = "version")
    private long version;

    @OneToMany(mappedBy = "country")
    private Set<Theme> themes = new HashSet<>();
}
