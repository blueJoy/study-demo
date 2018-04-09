package com.example.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty 客户端基本框架
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class NettyClient {

    private Channel channel;
    private ChannelInitializer channelInitializer;

    public NettyClient(ChannelInitializer channelInitializer) {
        this.channelInitializer = channelInitializer;
    }

    public Channel connect(String host, int port){
        doConnect(host,port);
        return this.channel;
    }

    private void doConnect(String host,int port){

        EventLoopGroup workGroup = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE,true)
                    .handler(channelInitializer);

            ChannelFuture sync = bootstrap.connect(host, port).sync();
            channel = sync.channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
