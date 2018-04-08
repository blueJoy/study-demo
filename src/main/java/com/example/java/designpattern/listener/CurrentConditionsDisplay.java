package com.example.java.designpattern.listener;

/**
 *  只显示当前温度和湿度的显示器
 *    可类似的扩展很多种
 * @author baixiangzhu
 * @date 2018/4/8
 **/
public class CurrentConditionsDisplay  implements Observer,IDisplay{

    private float temperature;
    private float humidity;
    private WeatherData data;

    public CurrentConditionsDisplay(WeatherData data){
        this.data = data;
        data.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions :" + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
