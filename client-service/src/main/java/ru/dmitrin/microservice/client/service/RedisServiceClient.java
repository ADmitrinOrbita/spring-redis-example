package ru.dmitrin.microservice.client.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dmitrin.microservice.domain.dto.UserDto;

@Log4j2
@RequiredArgsConstructor
@Service
public class RedisServiceClient {

    @Value("${redis.client.host}")
    private String url;

    private final RestTemplate restTemplate;

    public UserDto getById(String id) {
        log.info("Searching for User with id:{}", id);
        return restTemplate.getForObject(url + "/" + id, UserDto.class);
    }

    public ResponseEntity<UserDto[]> getAll() {
        log.info("Searching for all Users");
        return restTemplate.getForEntity(url + "/all", UserDto[].class);
    }

    public UserDto add(UserDto userDto) {
        log.info("Add new User with id:{} and name:{}", userDto.getId(), userDto.getName());
        return restTemplate.postForObject(url, userDto, UserDto.class);
    }

    public void update(UserDto userDto) {
        log.info("Updating new User with id:{} and name:{}", userDto.getId(), userDto.getName());
        restTemplate.put(url, userDto);
    }

    public void delete(String id) {
        log.info("Deleting User with id:{}", id);
        restTemplate.delete(url + "/" + id);
    }
}
