package com.example.java.spi;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
public class ImageHelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Say Image Hello!");
    }
}
