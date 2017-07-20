package com.example.java.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于spring的cglib实现
 * Created by baixiangzhu on 2017/7/20.
 */
public class CglibDynamicProxy {

    /**
     * CGLIB是基于ASM封装的，为什么会比ASM，javassist慢，是因为考虑了很多因素，导致生成的字节码比前两个大。
     * @param delegate
     * @return
     */
    public static Object getProxy(final Object delegate){

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibInterceptor(delegate));
        enhancer.setInterfaces(delegate.getClass().getInterfaces());
        Object result = enhancer.create();
        return result;
    }

    private static class CglibInterceptor implements MethodInterceptor{

        final Object delegate;

        public CglibInterceptor(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            return methodProxy.invoke(delegate,objects);
        }
    }

}
