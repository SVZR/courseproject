package by.itacademy.dao;

import by.itacademy.entity.Collection;

public class CollectionDao extends BaseDao<Collection> {
    @Override
    protected Class<Collection> getEntityClass() {
        return Collection.class;
    }
}
