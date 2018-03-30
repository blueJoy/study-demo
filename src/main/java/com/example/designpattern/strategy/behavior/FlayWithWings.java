package com.example.designpattern.strategy.behavior;

/**
 * @author baixiangzhu
 * @date 2018/3/30
 **/
public class FlayWithWings implements FlayBehavior {
    @Override
    public void flay() {
        System.out.println("用翅膀飞");
    }
}
