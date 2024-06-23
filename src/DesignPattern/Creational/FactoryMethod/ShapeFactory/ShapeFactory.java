package DesignPattern.Creational.FactoryMethod.ShapeFactory;

import DesignPattern.Creational.FactoryMethod.Shape.Circle;
import DesignPattern.Creational.FactoryMethod.Shape.Rectangle;
import DesignPattern.Creational.FactoryMethod.Shape.Shape;
import DesignPattern.Creational.FactoryMethod.Shape.ShapeTypeEnum;

public class ShapeFactory {
    Shape shape;

    public Shape getShape(ShapeTypeEnum type) {

        switch (type) {
            case CIRCLE: {
                this.shape = new Circle();
                return this.shape;
            }
            case RECTANGLE: {
                this.shape = new Rectangle();
                return this.shape;
            }
            default: {
                this.shape = null;
                return this.shape;
            }
        }
    }
}
