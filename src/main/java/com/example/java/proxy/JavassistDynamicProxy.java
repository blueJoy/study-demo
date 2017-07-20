package com.example.java.proxy;

import com.example.service.CountService;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.util.proxy.MethodHandler;
import org.apache.ibatis.javassist.util.proxy.ProxyFactory;
import org.apache.ibatis.javassist.util.proxy.ProxyObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * javassist框架动态代理实现
 *      基于：mybatis包中的javassist实现
 *
 * Created by baixiangzhu on 2017/7/20.
 */
public class JavassistDynamicProxy {

    /**
     * 通过接口的方式获取代理对象
     *      这种方式很慢，比JDK的实现还慢，不推荐使用
     * @param delegate
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object getProxyByInterface(final Object delegate) throws IllegalAccessException, InstantiationException {

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(delegate.getClass().getInterfaces());
        Class proxyClass = proxyFactory.createClass();
        Object result = proxyClass.newInstance();

        ((ProxyObject)result).setHandler(new JavaAssistInterceptor(delegate));

        return result;
    }


    /**
     * 通过字符串拼接的java源码，生成字节码
     *      跟ASM效率差别不大，比ASM方便
     * @param delegate
     * @return
     * @throws NotFoundException
     * @throws CannotCompileException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public static Object getProxyByCode(Object delegate) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        ClassPool mPool = new ClassPool(true);


        CtClass ctClass = mPool.makeClass(delegate.getClass().getName()+ "javassistByCodeProxy");
        //TODO:这个必须写接口吗？类名报错，怎么解决？
        ctClass.addInterface(mPool.get(CountService.class.getName()));
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        ctClass.addField(CtField.make("public " + delegate.getClass().getName() + " delegate;",ctClass));
        ctClass.addMethod(CtMethod.make("public int count() { return delegate.count();}",ctClass));
        Class resultClass = ctClass.toClass();
        Object result = resultClass.newInstance();
        Field field = result.getClass().getField("delegate");
        field.set(result,delegate);
        return result;
    }




    private static class JavaAssistInterceptor implements MethodHandler{

        final Object delegate;

        public JavaAssistInterceptor(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
            return method.invoke(delegate,objects);
        }
    }

}
