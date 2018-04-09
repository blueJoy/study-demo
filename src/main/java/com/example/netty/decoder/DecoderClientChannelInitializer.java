package com.example.netty.decoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


/**
 * 使用jdk序列化对象的方式
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class DecoderClientChannelInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline()
                .addLast("decoder",new MessageDecoder())
                .addLast("encoder",new MessageEncoder())
                .addLast("clientDecoderHandler",new ClientObjHandler());

    }
}
