package com.example.netty.helloword;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * hello world 的处理pipeline
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class HelloServerChannelInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline()
                .addLast("decoder",new StringDecoder())
                .addLast("encoder",new StringEncoder())
                .addLast("stringHandler",new StringHandler());

    }
}
