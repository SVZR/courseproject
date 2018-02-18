package by.itacademy.dao;

import by.itacademy.entity.CoinDescription;

public class CoinDescriptionDao extends BaseDao<CoinDescription> {
    @Override
    protected Class<CoinDescription> getEntityClass() {
        return CoinDescription.class;
    }
}
