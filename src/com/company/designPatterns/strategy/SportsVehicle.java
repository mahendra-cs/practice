package com.company.designPatterns.strategy;

public class SportsVehicle extends Vehicle{

    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }

    @Override
    public void drive() {
        driveStrategy.drive();
    }
}
