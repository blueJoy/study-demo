package com.example.utils.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * kryo序列化工具类
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class KryoSerializer {

    private static final ThreadlocalKryoFactory factory = new ThreadlocalKryoFactory();

    public static <T> Optional<byte[]> serialize(T obj){
        Kryo kryo = factory.getKryo();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeClassAndObject(output,obj);
        output.flush();
        output.close();

        byte[] bytes = baos.toByteArray();
        try{
            baos.flush();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(bytes);
    }

    public static <T> Optional<T> deserialize(ByteBuf out){
        if (null == out){
            return null;
        }

        Input input = new Input(new ByteBufInputStream(out));
        Kryo kryo = factory.getKryo();

        return Optional.ofNullable((T) kryo.readClassAndObject(input));
    }
}
