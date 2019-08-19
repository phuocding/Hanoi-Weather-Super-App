package com.fpt.theweatherapp.model;

public class Weather {

    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public Weather(String dateTime, int weatherIcon, String iconPhrase, com.fpt.theweatherapp.model.Temperature temperature) {
        DateTime = dateTime;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        Temperature = temperature;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public com.fpt.theweatherapp.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.fpt.theweatherapp.model.Temperature temperature) {
        Temperature = temperature;
    }
}
