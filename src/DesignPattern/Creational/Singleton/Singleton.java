package DesignPattern.Creational.Singleton;

public class Singleton {

    private final String value;
    public static Singleton instance;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String val) {
        if (instance == null) {
            instance = new Singleton(val);
        }

        return instance;
    }

    public String getValue() {
        return value;
    }
}
