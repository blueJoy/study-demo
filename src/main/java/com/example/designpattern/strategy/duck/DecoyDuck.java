package com.example.designpattern.strategy.duck;

/**
 * @author baixiangzhu
 * @date 2018/3/30
 **/
public class DecoyDuck extends Duck{
    @Override
    public void display() {
        System.out.println("我是诱饵鸭子");
    }
}
