package by.itacademy.dao;

import by.itacademy.entity.Sale;

public class SaleDao extends BaseDao<Sale> {
    @Override
    protected Class<Sale> getEntityClass() {
        return Sale.class;
    }
}
