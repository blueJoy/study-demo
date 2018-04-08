package com.example.java.designpattern.strategy.duck;

import com.example.java.designpattern.strategy.behavior.FlayBehavior;
import com.example.java.designpattern.strategy.behavior.QuackBehavior;

/**
 * 鸭子父类
 * @author baixiangzhu
 * @date 2018/3/30
 **/
public abstract class Duck {

    private FlayBehavior flayBehavior;
    private QuackBehavior quackBehavior;

    public void swim(){
        System.out.println("I can swim.");
    }

    public abstract void display();


    // ---------             -------------------

    public void performFly(){
        flayBehavior.flay();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    //---------------------           -----------------


    public void setFlayBehavior(FlayBehavior flayBehavior) {
        this.flayBehavior = flayBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
