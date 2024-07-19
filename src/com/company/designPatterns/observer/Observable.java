package com.company.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers;
    private int data;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        observers.forEach(Observer::update);
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
        notifyObservers();
    }

}
