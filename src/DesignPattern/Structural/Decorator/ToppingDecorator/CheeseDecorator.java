package DesignPattern.Structural.Decorator.ToppingDecorator;

import DesignPattern.Structural.Decorator.BasePizza.BasePizza;

public class CheeseDecorator implements ToppingDecorator {
    BasePizza basePizza;
    private final int costOfCheese = 30;

    public CheeseDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + costOfCheese;
    }
}
