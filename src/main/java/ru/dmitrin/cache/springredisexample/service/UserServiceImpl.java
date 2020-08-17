package ru.dmitrin.cache.springredisexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitrin.cache.springredisexample.domain.User;
import ru.dmitrin.cache.springredisexample.repository.UserRepository;

import java.util.Map;

import static org.springframework.util.StringUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save (String id, String name) {
        if (isEmpty(id) || isEmpty(name)) {
            throw new IllegalArgumentException();
        }

        userRepository.save(new User(id, name, 20000L));
        return userRepository.findById(id);
    }

    @Override
    public User update(String id, String name) {
        if (isEmpty(id) || isEmpty(name)) {
            throw new IllegalArgumentException();
        }

        userRepository.update(new User(id, name, 1000L));
        return userRepository.findById(id);
    }

    @Override
    public User findById(String id) {
        if (isEmpty(id)) {
            throw new IllegalArgumentException();
        }

        return userRepository.findById(id);
    }

    @Override
    public Map<String, User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (isEmpty(id)) {
            throw new IllegalArgumentException();
        }

        User user = userRepository.findById(id);

        if (user != null) {
            userRepository.delete(user);
        }
    }
}
