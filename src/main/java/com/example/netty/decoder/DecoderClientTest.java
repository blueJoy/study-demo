package com.example.netty.decoder;

import com.example.netty.NettyClient;
import io.netty.channel.Channel;

/**
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class DecoderClientTest {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 8888;

        Channel channel = new NettyClient(new DecoderClientChannelInitializer())
                .connect(host, port);

        Message message = new Message();
        message.setId("client 1");
        message.setContent("我是客户端");
        channel.writeAndFlush(message);

    }

}
