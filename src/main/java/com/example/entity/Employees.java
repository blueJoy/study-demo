package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
@Data
public class Employees {

    private Integer empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;

}
