package com.example.service.base;

import com.example.entity.Employees;

import java.io.Serializable;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
public interface BaseService<T,E extends Serializable> {

    int insert(T t);

    T findByEmpNo(E e);

}
