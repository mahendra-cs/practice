package com.company.designPatterns.observer;

public class Driver {
    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer mobileDisplay = new Observer(observable);
        Observer SmartWatchDisplay = new Observer(observable);
        Observer TvDisplay = new Observer(observable);
        observable.add(mobileDisplay);
        observable.add(SmartWatchDisplay);
        observable.add(TvDisplay);
        observable.setData(36);
    }
}
