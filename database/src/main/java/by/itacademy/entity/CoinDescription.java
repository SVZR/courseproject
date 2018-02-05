package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Embedded;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coin_description")
public class CoinDescription extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "coin_id", nullable = false)
    private Coin coin;

    @ManyToOne
    @JoinColumn(name = "metal_id", nullable = false)
    private Metal metal;

    @Column(name = "denomination")
    private long denomination;

    @Column(name = "weight")
    private double weight;

    @Column(name = "diameter")
    private double diameter;

    @Column(name = "mintage")
    private long mintage;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "imageAddress", column = @Column(name = "image_obverse", nullable = false, unique = true))
    )
    private ImageAddress imageObverse;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "imageAddress", column = @Column(name = "image_reverse", nullable = false, unique = true))
    )
    private ImageAddress imageReverse;

    @OneToMany(mappedBy = "coinDescription")
    private Set<Collection> collections = new HashSet<>();
}
