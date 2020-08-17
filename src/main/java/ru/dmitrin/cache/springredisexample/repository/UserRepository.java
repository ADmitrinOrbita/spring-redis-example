package ru.dmitrin.cache.springredisexample.repository;

import ru.dmitrin.cache.springredisexample.model.User;

import java.util.Map;

public interface UserRepository {

    void save (User user);
    Map<String, User> findAll();
    User findById(String id);
    void update(User user);
    void delete(User user);
}
