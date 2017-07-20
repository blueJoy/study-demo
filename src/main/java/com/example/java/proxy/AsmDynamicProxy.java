package com.example.java.proxy;

import com.example.service.CountService;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.lang.reflect.Field;

/**
 * 基于JDK asm实现
 *      需要手工写字节码
 * Created by baixiangzhu on 2017/7/20.
 */
public class AsmDynamicProxy {

    public static Object getProxy(final Object delegate) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        String className = delegate.getClass().getName() + "AsmProxy";
        String classPath = className.replace(".", "/");
        String interfacePath = CountService.class.getName().replace(".", "/");
        classWriter.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                classPath,
                null,
                "java/lang/Object",
                new String[]{interfacePath});

        //构造函数
        MethodVisitor initVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null);
        initVisitor.visitCode();
        initVisitor.visitVarInsn(Opcodes.ALOAD,0);
        initVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Object","<init>","()V");
        initVisitor.visitInsn(Opcodes.RETURN);
        initVisitor.visitMaxs(0,0);
        initVisitor.visitEnd();

        //count字段
        FieldVisitor fieldVisitor = classWriter.visitField(Opcodes.ACC_PUBLIC, "delegate", "L" + interfacePath + ";", null, null);
        fieldVisitor.visitEnd();

        //count()方法
        MethodVisitor countMethodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "count", "()I", null, null);
        countMethodVisitor.visitCode();
        countMethodVisitor.visitVarInsn(Opcodes.ALOAD,0);
        countMethodVisitor.visitFieldInsn(Opcodes.GETFIELD,classPath,"delegate","L"+interfacePath+";");
        countMethodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE,interfacePath,"count","()I");
        countMethodVisitor.visitInsn(Opcodes.IRETURN);
        countMethodVisitor.visitMaxs(0,0);
        countMethodVisitor.visitEnd();

        classWriter.visitEnd();
        byte[] code = classWriter.toByteArray();
        Object result = new ByteArrayClassLoader().getClass(className, code).newInstance();
        Field field = result.getClass().getField("delegate");
        field.set(result,delegate);
        return result;
    }

    private static class ByteArrayClassLoader extends ClassLoader{

        public ByteArrayClassLoader(){
            super(ByteArrayClassLoader.class.getClassLoader());
        }

        public synchronized Class getClass(String name,byte[] code){
            if(name == null)
                throw new IllegalStateException();

            return defineClass(name,code,0,code.length);
        }

    }

}
