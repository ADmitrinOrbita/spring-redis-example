package ru.dmitrin.cache.springredisexample.service;

import ru.dmitrin.cache.springredisexample.domain.User;

import java.util.Map;

public interface UserService {

    User save (String id, String name);

    User update(String id, String name);

    User findById(String id);

    Map<String, User> findAll();

    void delete(String id);
}
