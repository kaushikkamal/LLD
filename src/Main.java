import DesignPattern.Behavioral.Observer.ObserverDesignPatternDriver;
import DesignPattern.Behavioral.Strategy.StrategyDesignPatternDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Strategy Design Pattern start
        StrategyDesignPatternDriver.executeStrategyDesignPattern();

        //StrategyDesignPatternDriver.executeStrategyDesignPattern();
        // Strategy Design Pattern end

        // Observer Design Pattern start/
        ObserverDesignPatternDriver.executeObserverPattern();
        // Observer Design Pattern end
    }
}