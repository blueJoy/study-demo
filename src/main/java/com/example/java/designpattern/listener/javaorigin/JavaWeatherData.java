package com.example.java.designpattern.listener.javaorigin;

import java.util.Observable;

/**
 * 使用java实现
 * @author baixiangzhu
 * @date 2018/4/8
 **/
public class JavaWeatherData extends Observable{

    private float temperature;
    private float humidity;
    private float pressure;



    public void measurementsChanged(){
        super.setChanged();
        super.notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
