package src.interfaceModelo.application;

import src.interfaceModelo.entities.AbstractShape;
import src.interfaceModelo.entities.Circle;
import src.interfaceModelo.entities.Rectangle;
import src.interfaceModelo.enums.Color;

public class Program {
    public static void main(String[] args) {

        AbstractShape circle = new Circle(Color.BLACK, 2);
        AbstractShape rectangle = new Rectangle(Color.WHITE, 2, 2);
        System.out.println(circle);
        System.out.println();
        System.out.println(rectangle);
    }
}
