package ru.dmitrin.microservice.redis.service;

import org.springframework.stereotype.Service;
import ru.dmitrin.microservice.domain.dto.UserDto;
import ru.dmitrin.microservice.redis.domain.User;

@Service
public class UserMapper {

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .salary(user.getSalary())
                .build();
    }
}
