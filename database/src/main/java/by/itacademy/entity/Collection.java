package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "collection")
public class Collection extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "coindescription_id", nullable = false)
    private CoinDescription coinDescription;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "amount", nullable = false)
    private long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "sale", nullable = false)
    private SaleType sale;

    @Column(name = "cost")
    private BigDecimal cost;
}
