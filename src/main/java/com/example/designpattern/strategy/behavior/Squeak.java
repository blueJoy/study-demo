package com.example.designpattern.strategy.behavior;

/**
 * @author baixiangzhu
 * @date 2018/3/30
 **/
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
