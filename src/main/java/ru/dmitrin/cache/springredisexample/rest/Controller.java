package ru.dmitrin.cache.springredisexample.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmitrin.cache.springredisexample.model.User;
import ru.dmitrin.cache.springredisexample.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class Controller {

    private final UserRepository userRepository;

    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") String id,
                    @PathVariable("name") String name) {
        userRepository.save(new User(id, name, 20000L));
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") String id,
                       @PathVariable("name") String name) {
        userRepository.update(new User(id, name, 1000L));
        return userRepository.findById(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String, User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") String id) {
        User user = userRepository.findById(id);

        if (user != null) {
            userRepository.delete(user);
        }

        return userRepository.findAll();
    }
}
