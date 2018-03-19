package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "coin")
public class Coin extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "designer", nullable = false)
    private String designer;

    @Column(name = "minted_by", nullable = false)
    private String mintedBy;

    @Column(name = "description", nullable = false)
    private String description;

    @Embedded
    private ImageAddress imageAddress;

    @OneToMany(mappedBy = "coin")
    private Set<CoinDescription> coinDescriptions = new HashSet<>();
}
