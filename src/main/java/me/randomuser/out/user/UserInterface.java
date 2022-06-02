package me.randomuser.out.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInterface implements Serializable {
    private String id;
    private String name;
    private String gender;
    private String address;
    private String phone;
}
