package com.sankar.appdevlab.ui.Sensor;

public class MyData {
    private String weather,humidity,ph,sprinkler,temp,water;

    public MyData() {
    }

    public MyData(String weather, String humidity, String ph, String sprinkler, String temp, String water) {
        this.weather = weather;
        this.humidity = humidity;
        this.ph = ph;
        this.sprinkler = sprinkler;
        this.temp = temp;
        this.water = water;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getSprinkler() {
        return sprinkler;
    }

    public void setSprinkler(String sprinkler) {
        this.sprinkler = sprinkler;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }
}
