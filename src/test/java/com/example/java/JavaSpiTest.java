package com.example.java;

import com.example.java.spi.HelloService;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
public class JavaSpiTest {

    @Test
    public void testSpi(){

        ServiceLoader<HelloService> load = ServiceLoader.load(HelloService.class);

        for (HelloService service : load){
            service.sayHello();
        }

    }

}
