package com.melardev.spring.mybatiscrud.repositories;


import com.melardev.spring.mybatiscrud.entities.Todo;
import com.melardev.spring.mybatiscrud.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyBatisTodosRepository implements TodosRepository {

    public List<Todo> fetchAll() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Todo> todos = session.selectList("com.melardev.todos.selectAll");
        session.close();
        return todos;
    }

    @Override
    public Optional<Todo> fetchById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Todo todo = session.selectOne("com.melardev.todos.selectById", id);
        session.close();
        return Optional.ofNullable(todo);
    }


    @Override
    public Optional<Todo> fetchAsProxy(Long todoId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Todo todo = session.selectOne("com.melardev.todos.getProxy", todoId);
        session.close();
        return Optional.ofNullable(todo);
    }

    @Override
    public List<Todo> findByCompletedIs(boolean completed) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Todo> todos = session.selectList("com.melardev.todos.selectByCompletedIs", completed);
        session.close();
        return todos;
    }

    @Override
    public long count() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Object count = session.selectOne("com.melardev.todos.count");
        session.commit();
        session.close();

        return (long) count;
    }

    @Override
    public Todo save(Todo todo) {
        if (todo.getId() != null) {
            SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
            session.update("com.melardev.todos.update", todo);
            session.commit();
            session.close();
        } else {
            SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
            session.insert("com.melardev.todos.create", todo);
            session.commit();
            session.close();
        }
        return todo;
    }

    @Override
    public void delete(Todo todo) {
        deleteById(todo.getId());
    }

    @Override
    public void deleteById(Long entityId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("com.melardev.todos.deleteById", entityId);
        session.commit();
        session.close();
    }

    public int deleteAll() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        int affectedRows = session.delete("com.melardev.todos.deleteAll");
        session.commit();
        session.close();
        return affectedRows;
    }

}