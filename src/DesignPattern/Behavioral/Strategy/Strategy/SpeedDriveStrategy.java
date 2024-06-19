package DesignPattern.Behavioral.Strategy.Strategy;

import DesignPattern.Behavioral.Strategy.Strategy.DriveStrategy;

public class SpeedDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Speed Drive Strategy");
    }
}
