package com.example.java.designpattern.listener.javaorigin;

import com.example.java.designpattern.listener.IDisplay;

import java.util.Observable;
import java.util.Observer;

/**
 * @author baixiangzhu
 * @date 2018/4/8
 **/
public class JavaCurrentConditionDisplay implements IDisplay,Observer {

    private float temperature;
    private float humidity;
    private Observable observable;

    public JavaCurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("java  Current Conditions :" + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof JavaWeatherData){
            JavaWeatherData javaWeatherData = (JavaWeatherData) o;
            //采用拉取的方式获取数据
            this.temperature = javaWeatherData.getTemperature();
            this.humidity = javaWeatherData.getHumidity();
            display();
        }
    }
}
