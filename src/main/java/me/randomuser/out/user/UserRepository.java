package me.randomuser.out.user;

import org.springframework.cache.annotation.Cacheable;

public interface UserRepository {
    @Cacheable(value = "userCache")
    public UserInterface get(int id);
}
