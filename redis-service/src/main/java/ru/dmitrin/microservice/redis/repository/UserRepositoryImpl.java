package ru.dmitrin.microservice.redis.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.dmitrin.microservice.redis.domain.User;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Value("${spring.redis.key}")
    private String key;

    private final HashOperations<String, String, User> hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(key, user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(key);
    }

    @Override
    public User findById(String id) {
        return hashOperations.get(key, id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(User user) {
        hashOperations.delete(key, user);
    }
}
