import ElevatorSystem.ElevatorDrive;
import ParkingLotSystem.ParkingLotDriver;
import TicTacToeSystem.TicTacToeGame;

public class Main {
    public static void main(String[] args) {
//        StrategyDesignPatternDriver.execute(); // Strategy Design Pattern
//        ObserverDesignPatternDriver.execute(); // Observer Design Pattern
//        SingletonDesignPatternDriver.execute(); // Singleton Design Pattern
//        DecoratorDesignPatternDriver.execute(); // Decorator Design Pattern
//        FactoryDesignPatternDriver.execute(); // Factory Design Pattern
//        AbstractFactoryDesignPatternDriver.execute(); // Abstract Factory Design Pattern

//        ElevatorSystemDemo.run();
//        ElevatorSystemDriver.execute();
//        ElevatorDrive.execute();

//        ParkingLotDriver.execute();

        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame(3);
        String result = game.startGame();
        System.out.println(result);
    }
}