package ru.dmitrin.microservice.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.dmitrin.microservice.domain.dto.UserDto;
import ru.dmitrin.microservice.redis.domain.User;
import ru.dmitrin.microservice.redis.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.isEmpty;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto save(String id, String name) {
        log.info("Add new User with id:{} and name:{}", id, name);

        if (isEmpty(id) || isEmpty(name)) {
            log.error("'id' and 'name' field values must be not empty!");
            throw new IllegalArgumentException();
        }

        User user = new User(id, name, 20000L);
        userRepository.save(user);
        return userMapper.toUserDto(userRepository.findById(id));
    }

    @Override
    public UserDto update(String id, String name) {
        log.info("Updating new User with id:{} and name:{}", id, name);

        if (isEmpty(id) || isEmpty(name)) {
            log.error("'id' and 'name' field values must be not empty!");
            throw new IllegalArgumentException();
        }

        userRepository.update(new User(id, name, 1000L));
        return userMapper.toUserDto(userRepository.findById(id));
    }

    @Override
    public UserDto findById(String id) {
        log.info("Searching for User with id:{}", id);

        if (isEmpty(id)) {
            log.error("'id' field value must be not empty!");
            throw new IllegalArgumentException();
        }

        return userMapper.toUserDto(userRepository.findById(id));
    }

    @Override
    public List<UserDto> findAll() {
        log.info("Searching for all Users");
        return userRepository.findAll().values().stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        log.info("Deleting User with id:{}", id);

        if (isEmpty(id)) {
            log.error("'id' field value must be not empty!");
            throw new IllegalArgumentException();
        }

        User user = userRepository.findById(id);

        if (user != null) {
            userRepository.delete(user);
        }
    }
}
