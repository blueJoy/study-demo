package com.example.netty.kyro;

import com.example.utils.kryo.KryoSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.Optional;

/**
 * kryo解码器
 *
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class KryoDecoder extends ByteToMessageDecoder{

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {

        Optional<byte[]> obj = KryoSerializer.serialize(in);
        out.add(obj.get());
    }
}
