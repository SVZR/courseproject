package by.itacademy.service;

import java.math.BigDecimal;

/**
 * @author kirylhrybouski
 */
public interface SaleService {

    void addCoinForSale(long coinDescriptionId, BigDecimal cost, String userLogin);
}
