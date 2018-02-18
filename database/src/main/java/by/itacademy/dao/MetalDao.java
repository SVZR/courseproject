package by.itacademy.dao;

import by.itacademy.entity.Metal;

public class MetalDao extends BaseDao<Metal> {
    @Override
    protected Class<Metal> getEntityClass() {
        return Metal.class;
    }
}
