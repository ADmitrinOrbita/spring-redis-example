package ru.dmitrin.cache.springredisexample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.dmitrin.cache.springredisexample.domain.User;
import ru.dmitrin.cache.springredisexample.repository.UserRepository;

import java.util.Map;

import static org.springframework.util.StringUtils.isEmpty;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(String id, String name) {
        log.info("Saving new User with id:{} and name:{}", id, name);

        if (isEmpty(id) || isEmpty(name)) {
            log.error("'id' and 'name' field values must be not empty!");
            throw new IllegalArgumentException();
        }

        User user = new User(id, name, 20000L);
        userRepository.save(user);
        return userRepository.findById(id);
    }

    @Override
    public User update(String id, String name) {
        log.info("Updating new User with id:{} and name:{}", id, name);

        if (isEmpty(id) || isEmpty(name)) {
            log.error("'id' and 'name' field values must be not empty!");
            throw new IllegalArgumentException();
        }

        userRepository.update(new User(id, name, 1000L));
        return userRepository.findById(id);
    }

    @Override
    public User findById(String id) {
        log.info("Searching for User with id:{}", id);

        if (isEmpty(id)) {
            log.error("'id' field value must be not empty!");
            throw new IllegalArgumentException();
        }

        return userRepository.findById(id);
    }

    @Override
    public Map<String, User> findAll() {
        log.info("Searching for all Users");
        return userRepository.findAll();
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
