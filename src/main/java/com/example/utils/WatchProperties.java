package com.example.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author baixiangzhu
 * @date 2017/12/27
 **/
public class WatchProperties {

    private static WatchService watchService;
    private static String filename;
    private static Properties properties;
    private static ClassPathResource resource;

    static {

        try {
            //读取的配置文件，在资源文件夹下就行
            filename = "prop/watchServiceTest.properties";
            resource = new ClassPathResource(filename);
            //监听filename所在目录下的文件修改、删除事件
            watchService = FileSystems.getDefault().newWatchService();
            Paths.get(resource.getFile().getParent()).register(watchService,
                    StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch(IOException e) {
            e.printStackTrace();
        }

        //启动一个线程监听内容变化，并重新载入配置
        Thread watchThread = new Thread() {
            public void run() {
                while(true) {
                    try {
                        WatchKey watchKey = watchService.take();
                        for (WatchEvent event : watchKey.pollEvents()) {
                            if (Objects.equals(event.context().toString(), filename)){
                                properties = PropertiesLoaderUtils.loadProperties (resource);
                                break;
                            }
                            watchKey.reset();
                        }
                    } catch (Exception e) {

                    }
                }
            };
        };

        //设置成守护进程
        watchThread.setDaemon(true);
        watchThread.start();

        //当服务器进程关闭时把监听线程close掉
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try{
                    watchService.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public static String get(String key){
        return properties.getProperty(key, "");
    }

    public static void main(String[] args) {
        while (true){
            System.out.println(">>>>>>>>>>>>>>" + properties.get("prop1"));
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
