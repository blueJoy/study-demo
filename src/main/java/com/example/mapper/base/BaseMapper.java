package com.example.mapper.base;

import com.example.entity.Titles;

import java.io.Serializable;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
public interface BaseMapper<T,E extends Serializable> {

    int insert(T t);

    int updateByPrimaryKey(T t);

    T selectByEmpNo(E e);

    int deleteByEmpNo(E e);

}
