package com.example.netty.decoder;

import com.example.utils.ByteUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.Optional;

/**
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class MessageEncoder extends MessageToByteEncoder<Message>{

    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        Optional<byte[]> bytes = ByteUtils.objectToByte(message);
        out.writeBytes(bytes.get());
        ctx.flush();
    }
}
