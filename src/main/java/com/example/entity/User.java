package com.example.entity;

import lombok.Data;

/**
 * Created by baixiangzhu on 2017/7/18.
 */
@Data
public class User {

    private String id;
    private String name;
    private String sex;
    private int age;

    public User(){}

    public User(String id,String name){
        this.id = id;
        this.name = name;
    }

}
