package com.example.java.designpattern.listener;

import java.util.ArrayList;

/**
 * @author baixiangzhu
 * @date 2018/4/8
 **/
public class WeatherData implements Subject{

    private static ArrayList<Observer> observers = new ArrayList<>();

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i > 0 ){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers){
            observer.update(this.temperature,this.humidity,this.pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
