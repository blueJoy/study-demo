package com.example.utils;

import io.netty.buffer.ByteBuf;

import java.io.*;
import java.util.Optional;

/**
 * 字符数组和对象转换工具类
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class ByteUtils {


    /**
     * object 转换成byte[]
     * @param obj
     * @param <T>
     * @return
     */
    public static<T> Optional<byte[]> objectToByte(T obj){

        byte [] bytes = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ObjectOutputStream sout;

        try{
            sout = new ObjectOutputStream(baos);
            sout.writeObject(obj);
            sout.flush();

            bytes = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(bytes);
    }

    /**
     * byte[] 转换成对象
     * @param bytes
     * @param <T>
     * @return
     */
    public static <T> Optional<T> byteToObject(byte[] bytes){
        T obj = null;

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

        ObjectInputStream sin ;

        try{
            sin = new ObjectInputStream(bais);
            obj = (T) sin.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(obj);
    }

    /**
     * 读byteBuf中的字符数组
     * @param byteBuf
     * @return
     */
    public static Optional<byte[]> read(ByteBuf byteBuf){

        byte[] buf = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(buf);

        return Optional.ofNullable(buf);
    }

}
