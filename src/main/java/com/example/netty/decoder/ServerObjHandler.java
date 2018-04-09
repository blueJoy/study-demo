package com.example.netty.decoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class ServerObjHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof Message){
            Message message = (Message) msg;
            System.out.println("server receive :" +message);

            Message returnMsg = new Message();
            returnMsg.setId("server111");
            returnMsg.setContent("messgae 服务端返回");
            ctx.writeAndFlush(returnMsg);
        }else {
            System.out.println("error type..");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
