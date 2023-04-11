package src.interfaceModelo.entities;

import src.interfaceModelo.enums.Color;
abstract public class AbstractShape implements Shape{

    private Color color;

    public AbstractShape(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nColor : " + color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
