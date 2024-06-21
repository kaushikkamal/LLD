package DesignPattern.Structural.Decorator.ToppingDecorator;

import DesignPattern.Structural.Decorator.BasePizza.BasePizza;

public class OnionDecorator implements ToppingDecorator {
    BasePizza basePizza;
    private final int costOfOnion = 40;

    public OnionDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + costOfOnion;
    }
}
