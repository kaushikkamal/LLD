package DesignPattern.Behavioral.Strategy.Strategy;

import DesignPattern.Behavioral.Strategy.Strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
