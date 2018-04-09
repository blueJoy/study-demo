package com.example.netty.helloword;

import com.example.netty.NettyServer;

/**
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class HelloServerTest {


    public static void main(String[] args) {

        int port = 8888;

        new Thread(()->{
           new NettyServer(new HelloServerChannelInitializer()).start(port);
        }).start();
    }

}
