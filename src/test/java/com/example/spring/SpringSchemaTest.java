package com.example.spring;

import com.example.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by baixiangzhu on 2017/7/18.
 */
public class SpringSchemaTest {

    @Test
    public void testSchema(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-schema-test.xml");
        User user = (User) context.getBean("userTest");
        System.out.println(user);
    }

}
