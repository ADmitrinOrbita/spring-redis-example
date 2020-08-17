package ru.dmitrin.cache.springredisexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private String id;
    private String name;
    private Long salary;
}
