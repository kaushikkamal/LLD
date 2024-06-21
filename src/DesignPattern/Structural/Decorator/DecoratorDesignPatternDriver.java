package DesignPattern.Structural.Decorator;

import DesignPattern.Structural.Decorator.BasePizza.BasePizza;
import DesignPattern.Structural.Decorator.BasePizza.NonVegPizza;
import DesignPattern.Structural.Decorator.ToppingDecorator.CheeseDecorator;
import DesignPattern.Structural.Decorator.ToppingDecorator.OnionDecorator;
import DesignPattern.Structural.Decorator.ToppingDecorator.ToppingDecorator;

public class DecoratorDesignPatternDriver {
    public static void execute() {
//        BasePizza basePizza = new NonVegPizza();
//        ToppingDecorator toppingDecorator = new CheeseDecorator(basePizza);
//        ToppingDecorator toppingDecorator2 = new CheeseDecorator(toppingDecorator);
//        System.out.println(toppingDecorator2.cost());

        BasePizza pizza = new CheeseDecorator(new OnionDecorator(new CheeseDecorator(new NonVegPizza())));
        System.out.println(pizza.cost());
    }
}
