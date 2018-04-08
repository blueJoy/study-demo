package com.example.java.designpattern.strategy;

import com.example.java.designpattern.strategy.behavior.FlayWithWings;
import com.example.java.designpattern.strategy.behavior.Squeak;
import com.example.java.designpattern.strategy.duck.DecoyDuck;
import com.example.java.designpattern.strategy.duck.Duck;

/**
 *
 *   策略设计模式：
 *        定义了算法簇，封装起来，他们之间可以相互替换。让算法独立于算法的使用客户。
 *
 *   实践：实例中的行为的集合就表示一类算法簇。以组合的接口的形式在客户中使用，
 *          可以动态替换不同是算法，且方便算法的扩展。
 *
 * @author baixiangzhu
 * @date 2018/3/30
 **/
public class StrategyTest {

    public static void main(String[] args) {

        Duck duck = new DecoyDuck();

        duck.display();

        duck.setFlayBehavior(new FlayWithWings());
        duck.performFly();

        duck.setQuackBehavior(new Squeak());
        duck.performQuack();


    }

}
