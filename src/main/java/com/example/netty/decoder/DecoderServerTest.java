package com.example.netty.decoder;

import com.example.netty.NettyServer;

/**
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class DecoderServerTest {

    public static void main(String[] args) {

        int port = 8888;

        new Thread(()->{
            new NettyServer(new DecoderServerChannelInitializer())
                    .start(port);
        }).start();
    }

}
