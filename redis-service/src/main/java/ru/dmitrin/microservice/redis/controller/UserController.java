package ru.dmitrin.microservice.redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dmitrin.microservice.domain.dto.UserDto;
import ru.dmitrin.microservice.redis.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto add(@RequestBody UserDto userDto) {
        return userService.save(userDto.getId(), userDto.getName());
    }

    @PutMapping
    public void update(@RequestBody UserDto userDto) {
        userService.update(userDto.getId(), userDto.getName());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }
}
