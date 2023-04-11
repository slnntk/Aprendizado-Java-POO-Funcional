package src.interfaceModelo.entities;

import src.interfaceModelo.enums.Color;

public class Rectangle extends AbstractShape{

    private final double width;
    private final double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return getHeight() * getWidth();
    }

    @Override
    public String toString() {
        return "Rectangle:" +
                "\nWidth : " + width +
                "\nHeight : " + height +
                "\nArea : " + area()
                + super.toString();
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
