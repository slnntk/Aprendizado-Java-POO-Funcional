package src.interfaceModelo.entities;

import src.interfaceModelo.enums.Color;

public class Circle extends AbstractShape{

    private final double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.round(Math.PI * Math.pow(getRadius(), 2) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Circle\n" +
                "Radius : " + radius +
                "\nArea : " + area()
                + super.toString();
    }

    public double getRadius() {
        return radius;
    }
}
