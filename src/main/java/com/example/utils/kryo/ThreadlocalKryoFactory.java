package com.example.utils.kryo;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author baixiangzhu
 * @date 2018/4/9
 **/
public class ThreadlocalKryoFactory extends KryoFactory {


    private final ThreadLocal<Kryo> holder = new ThreadLocal<Kryo>(){

        //线程第一次调用的时候，给定初始值
        @Override
        protected Kryo initialValue() {
            return createKryo();
        }
    };

    public Kryo getKryo(){
        return holder.get();
    }
}
