package ru.dmitrin.cache.springredisexample.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmitrin.cache.springredisexample.domain.User;
import ru.dmitrin.cache.springredisexample.service.UserService;
import ru.dmitrin.cache.springredisexample.service.UserServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") String id,
                    @PathVariable("name") String name) {
        return userService.save(id, name);
    }

    @PutMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") String id,
                       @PathVariable("name") String name) {
        return userService.update(id, name);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @GetMapping("/all")
    public Map<String, User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }
}
