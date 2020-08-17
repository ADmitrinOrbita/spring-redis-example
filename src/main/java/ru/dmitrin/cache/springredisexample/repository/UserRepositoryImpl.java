package ru.dmitrin.cache.springredisexample.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.dmitrin.cache.springredisexample.domain.User;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public static final String USER = "USER";

    private final HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(USER, user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(USER);
    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get(USER, id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(User user) {
        hashOperations.delete(USER, user);
    }
}
