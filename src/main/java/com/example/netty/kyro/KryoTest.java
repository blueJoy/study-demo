package com.example.netty.kyro;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.example.netty.decoder.Message;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * kyro测试类
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class KryoTest {

    public static void main(String[] args) throws FileNotFoundException {

        // 序列化
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.bin"));
        Message someObject = new Message();
        someObject.setContent("测试序列化");
        kryo.writeObject(output, someObject);
        output.close();
        // 反序列化
        Input input = new Input(new FileInputStream("file.bin"));
        Message message = kryo.readObject(input, Message.class);
        System.out.println(message.getContent());
        input.close();

    }

}
