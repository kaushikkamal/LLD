package DesignPattern.Structural.Decorator.ToppingDecorator;

import DesignPattern.Structural.Decorator.BasePizza.BasePizza;

public interface ToppingDecorator extends BasePizza {
    int cost();
}
