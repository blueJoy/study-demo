package com.example.service.impl;

import com.example.service.CountService;

/**
 * Created by baixiangzhu on 2017/7/20.
 */
public class CountServiceImpl implements CountService {

    private int count = 0;


    @Override
    public int count() {
        return count ++;
    }
}
