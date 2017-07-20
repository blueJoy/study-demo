package com.example.spring.schema;

import com.example.entity.User;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by baixiangzhu on 2017/7/18.
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport{

    @Override
    public void init() {

        //registerBeanDefinitionParser("user",new UserBeanDefinitionParser());

        registerBeanDefinitionParser("user",new UserBeanDefinitionParser2(User.class));
    }
}
