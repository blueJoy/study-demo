package com.example.netty.kyro;

import com.example.netty.decoder.Message;
import com.example.utils.kryo.KryoSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.Optional;

/**
 * kryo编码器
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class kryoEncoder extends MessageToByteEncoder<Message>{
    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {

        Optional<byte[]> bytes = KryoSerializer.serialize(message);

        out.writeBytes(bytes.get());

        ctx.flush();

    }
}
