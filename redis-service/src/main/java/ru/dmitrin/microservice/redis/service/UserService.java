package ru.dmitrin.microservice.redis.service;

import ru.dmitrin.microservice.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save (String id, String name);

    UserDto update(String id, String name);

    UserDto findById(String id);

    List<UserDto> findAll();

    void delete(String id);
}
