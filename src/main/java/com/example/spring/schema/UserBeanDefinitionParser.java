package com.example.spring.schema;

import com.example.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * Created by baixiangzhu on 2017/7/18.
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String sex = element.getAttribute("sex");
        int age = Integer.parseInt(element.getAttribute("age"));

        builder.addPropertyValue("id",id);
        builder.addPropertyValue("name",name);
        builder.addPropertyValue("sex",sex);
        builder.addPropertyValue("age",age);
    }
}
