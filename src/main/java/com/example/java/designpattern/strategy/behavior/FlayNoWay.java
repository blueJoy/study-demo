package com.example.java.designpattern.strategy.behavior;

/**
 * @author baixiangzhu
 * @date 2018/3/30
 **/
public class FlayNoWay implements FlayBehavior {
    @Override
    public void flay() {
        System.out.println("可惜我不能飞");
    }
}
