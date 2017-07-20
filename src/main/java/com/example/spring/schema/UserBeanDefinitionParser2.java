package com.example.spring.schema;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by baixiangzhu on 2017/7/18.
 */
public class UserBeanDefinitionParser2 implements BeanDefinitionParser {

    private final Class<?> beanClass;

    public UserBeanDefinitionParser2(Class<?> beanClass){

        this.beanClass = beanClass;
    }


    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String sex = element.getAttribute("sex");
        int age = Integer.parseInt(element.getAttribute("age"));

        //注册bean
        parserContext.getRegistry().registerBeanDefinition(id,beanDefinition);

        beanDefinition.getPropertyValues().addPropertyValue("id",id);
        beanDefinition.getPropertyValues().addPropertyValue("name",name);
        beanDefinition.getPropertyValues().addPropertyValue("sex",sex);
        beanDefinition.getPropertyValues().addPropertyValue("age",age);


        return beanDefinition;
    }
}
