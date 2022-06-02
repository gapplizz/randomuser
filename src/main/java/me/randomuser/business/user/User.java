package me.randomuser.business.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private final String name;
    private final String gender;
    private final String address;
}
