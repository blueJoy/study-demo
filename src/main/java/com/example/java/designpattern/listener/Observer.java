package com.example.java.designpattern.listener;

/**
 * Created by baixiangzhu on 2018/4/8.
 */
public interface Observer {

    /**
     *
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp,float humidity,float pressure);
}