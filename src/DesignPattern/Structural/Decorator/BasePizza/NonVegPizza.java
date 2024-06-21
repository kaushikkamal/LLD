package DesignPattern.Structural.Decorator.BasePizza;

public class NonVegPizza implements BasePizza {

    private final int cost = 150;

    @Override
    public int cost() {
        return cost;
    }
}
