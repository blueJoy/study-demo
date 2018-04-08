package com.example.java.designpattern.listener;

import com.example.java.designpattern.listener.javaorigin.JavaCurrentConditionDisplay;
import com.example.java.designpattern.listener.javaorigin.JavaWeatherData;

/**
 * 气象站，测试类
 *      可以使用java自带的java.util.Observer类实现监听者模式
 * @author baixiangzhu
 * @date 2018/4/8
 **/
public class WeatherStation {

    public static void main(String[] args) {

        //自己实现的
        WeatherData data = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(data);
        data.setMeasurements(80, 65, 30.4f);
        data.setMeasurements(82, 70, 29.2f);


        //使用java内置的监听者模式
        /**
         * 缺点：
         *  Observable 是类而不是接口，以为java不支持多继承，所以不能继承其他超类的行为了。
         */
        JavaWeatherData javaWeatherData = new JavaWeatherData();
        JavaCurrentConditionDisplay javaCurrentConditionDisplay = new JavaCurrentConditionDisplay(javaWeatherData);
        javaWeatherData.setMeasurements(78, 90, 29.2f);
    }

}
