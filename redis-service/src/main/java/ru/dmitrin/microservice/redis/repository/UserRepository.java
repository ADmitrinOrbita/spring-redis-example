package ru.dmitrin.microservice.redis.repository;

import ru.dmitrin.microservice.redis.domain.User;

import java.util.Map;

public interface UserRepository {

    void save (User user);

    Map<String, User> findAll();

    User findById(String id);

    void update(User user);

    void delete(User user);
}
