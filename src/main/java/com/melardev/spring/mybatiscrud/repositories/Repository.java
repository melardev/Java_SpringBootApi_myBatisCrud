package com.melardev.spring.mybatiscrud.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    List<T> fetchAll();

    Optional<T> fetchById(ID id);

    Optional<T> fetchAsProxy(ID id);

    long count();

    T save(T entity);

    int deleteAll();

    void delete(T entity);

    void deleteById(ID entityId);


}
