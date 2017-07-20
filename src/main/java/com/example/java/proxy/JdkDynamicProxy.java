package com.example.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by baixiangzhu on 2017/7/20.
 */
public class JdkDynamicProxy {

    /**
     * 生成的字节码也很大。比cglib,javassist,asm都要慢些
     * @param delegate
     * @return
     */
    public static Object getProxy(final Object delegate){

        Object result = Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                new JdkHandler(delegate));

        return result;
    }

    private static class JdkHandler implements InvocationHandler{

        final Object delegate;

        public JdkHandler(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            return method.invoke(delegate,args);
        }
    }

}
