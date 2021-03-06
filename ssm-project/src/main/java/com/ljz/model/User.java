package com.ljz.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    @Override
    public String toString() {
        return "User [id=" + id +
                ", userName=" + userName +
                ", password=" + password +
                ", age=" + age + "]";
    }

}