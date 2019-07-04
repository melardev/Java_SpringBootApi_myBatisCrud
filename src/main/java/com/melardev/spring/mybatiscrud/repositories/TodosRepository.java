package com.melardev.spring.mybatiscrud.repositories;


import com.melardev.spring.mybatiscrud.entities.Todo;

import java.util.List;

public interface TodosRepository extends Repository<Todo, Long> {
    List<Todo> findByCompletedIs(boolean completed);
}
