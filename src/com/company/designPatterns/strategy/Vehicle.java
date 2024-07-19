package com.company.designPatterns.strategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    void drive(){
        driveStrategy.drive();
    }
}
