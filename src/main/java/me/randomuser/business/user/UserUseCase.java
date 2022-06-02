package me.randomuser.business.user;

import org.springframework.lang.Nullable;

public interface UserUseCase {
    public User randomUser(@Nullable String seed);
}
