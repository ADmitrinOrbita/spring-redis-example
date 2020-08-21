package ru.dmitrin.microservice.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitrin.microservice.domain.dto.UserDto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final RedisServiceClient redisServiceClient;

    public UserDto getById(String id) {
        return redisServiceClient.getById(id);
    }

    public Collection<UserDto> getAll() {
        return Arrays.stream(Objects.requireNonNull(redisServiceClient.getAll().getBody()))
                .collect(Collectors.toList());
    }

    public UserDto add(UserDto userDto) {
        return redisServiceClient.add(userDto);
    }

    public void update(UserDto userDto) {
        redisServiceClient.update(userDto);
    }

    public void delete(String id) {
        redisServiceClient.delete(id);
    }
}
