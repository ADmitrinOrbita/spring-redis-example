package ru.dmitrin.microservice.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dmitrin.microservice.client.service.ClientService;
import ru.dmitrin.microservice.domain.dto.UserDto;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client/users")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") String id) {
        return clientService.getById(id);
    }

    @GetMapping("/all")
    public Collection<UserDto> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    public UserDto add(@RequestBody UserDto userDto) {
        return clientService.add(userDto);
    }

    @PutMapping
    public void update(@RequestBody UserDto userDto) {
        clientService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        clientService.delete(id);
    }
}
