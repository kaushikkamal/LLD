package DesignPattern.Creational.Singleton;

public class SingletonDesignPatternDriver {

    public static void execute() {
        Singleton singleton1 = Singleton.getInstance("First Value");
        System.out.println(singleton1.getValue()); // op: First Value

        Singleton singleton2 = Singleton.getInstance("Second Value");
        System.out.println(singleton2.getValue()); // op: First Value
    }
}
