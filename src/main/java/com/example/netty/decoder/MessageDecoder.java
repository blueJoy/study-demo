package com.example.netty.decoder;

import com.example.utils.ByteUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.Optional;

/**
 * 对象解码器
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        Optional<Object> obj = ByteUtils.byteToObject(ByteUtils.read(in).get());

        out.add(obj.get());
    }
}
