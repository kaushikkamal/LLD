import DesignPattern.Behavioral.Observer.ObserverDesignPatternDriver;
import DesignPattern.Behavioral.Strategy.StrategyDesignPatternDriver;
import DesignPattern.Creational.Singleton.SingletonDesignPatternDriver;

public class Main {
    public static void main(String[] args) {
        StrategyDesignPatternDriver.execute(); // Strategy Design Pattern

        ObserverDesignPatternDriver.execute(); // Observer Design Pattern

        SingletonDesignPatternDriver.execute(); // Singleton Design Pattern
    }
}