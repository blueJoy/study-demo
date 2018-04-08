package com.example.java.designpattern.listener;

/**
 * 主题接口
 * Created by baixiangzhu on 2018/4/8.
 */
public interface Subject {

    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 变更通知观察者
     */
    void notifyObservers();
}
