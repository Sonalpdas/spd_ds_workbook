package design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

    private List<Observer> observers; // Added list object to hold all observers to be created in constructor
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature(){
        return this.temperature;
    }

    public float getHumidity(){
        return this.humidity;
    }

    public float getPressure(){
        return this.pressure;
    }

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer observer: observers){
//            observer.update(temperature, humidity, pressure); // Calling update from observer interface w parameter - push method
            observer.update(); // Calling update from observer interface w/o parameter - pull method
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this. humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }



}
