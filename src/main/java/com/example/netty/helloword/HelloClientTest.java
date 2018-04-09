package com.example.netty.helloword;

import com.example.netty.NettyClient;
import io.netty.channel.Channel;

/**
 * 客户端
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class HelloClientTest {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8888;
        Channel channel = new NettyClient(new HelloClientChannelInitializer())
                .connect(host, port);
        channel.writeAndFlush("我是测试大");
    }

}
