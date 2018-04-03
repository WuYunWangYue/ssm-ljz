package com.ljz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Person {
    private String userName;
    private String password;
    private String age;

    @Override
    public String toString() {
        return "Person [userName=" + userName +
                ", password=" + password +
                ", age=" + age + "]";
    }

}
