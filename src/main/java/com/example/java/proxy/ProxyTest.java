package com.example.java.proxy;

import com.example.service.CountService;
import com.example.service.impl.CountServiceImpl;
import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.NotFoundException;

/**
 * Created by baixiangzhu on 2017/7/20.
 */
public class ProxyTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, CannotCompileException, NotFoundException {

        CountService countService = new CountServiceImpl();

        CountService jdkProxy = (CountService) JdkDynamicProxy.getProxy(countService);
        System.out.println(jdkProxy.count());


        CountService cglibProxy = (CountService) CglibDynamicProxy.getProxy(countService);
        System.out.println(cglibProxy.count());

        CountService javassistInterfaceProxy = (CountService) JavassistDynamicProxy.getProxyByInterface(countService);
        System.out.println(javassistInterfaceProxy.count());


        CountService javassistByCodeProxy = (CountService) JavassistDynamicProxy.getProxyByCode(countService);
        System.out.println(javassistByCodeProxy.count());


        CountService asmProxy = (CountService) AsmDynamicProxy.getProxy(countService);
        System.out.println(asmProxy.count());
    }

}
