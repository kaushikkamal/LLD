package DesignPattern.Creational.FactoryMethod;

import DesignPattern.Creational.FactoryMethod.Shape.Shape;
import DesignPattern.Creational.FactoryMethod.ShapeFactory.ShapeFactory;

public class FactoryDesignPatternDriver {
    public static void execute() {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape(ShapeTypeEnum.CIRCLE);
        Shape shape2 = shapeFactory.getShape(ShapeTypeEnum.RECTANGLE);

        shape1.draw();
        shape2.draw();

    }
}
