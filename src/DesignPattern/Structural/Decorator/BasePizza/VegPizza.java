package DesignPattern.Structural.Decorator.BasePizza;

public class VegPizza implements BasePizza {

    private final int cost = 100;

    @Override
    public int cost() {
        return cost;
    }
}
