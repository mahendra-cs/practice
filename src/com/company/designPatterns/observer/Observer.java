package com.company.designPatterns.observer;

public class Observer {
    private final Observable observable;

    public Observer(Observable observable) {
        this.observable = observable;
    }

    public void update() {
        System.out.println("Got new update!! "+" "+observable.getData());
    }
}
