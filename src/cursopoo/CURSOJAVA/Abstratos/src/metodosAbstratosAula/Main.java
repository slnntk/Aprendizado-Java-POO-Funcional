package metodosAbstratosAula;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new CalculadoraDeArea();

    }
}

class CalculadoraDeArea{

    List<Shape> shapeList = new ArrayList<>();

    public CalculadoraDeArea() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of shapes: ");int nFormas = sc.nextInt();
        CriadorDeShapes(nFormas, sc);
        ImpressaoAreas();
    }

    public void ImpressaoAreas(){

        System.out.println();
        System.out.println("SHAPE AREAS");
        for (Shape shapes : shapeList){
            System.out.printf("%.2f%n", shapes.area());
        }

    }

    public void CriadorDeShapes(int nFormas, Scanner sc){

        for (int i = 1;i <= nFormas;i++){
            System.out.printf("metodosAbstratos.Shape #%d data:%n", i);

            System.out.printf("metodosAbstratos.Rectangle or metodosAbstratos.Circle (r/c) ");char tipoShape = sc.next().toLowerCase().charAt(0);
            System.out.printf("Colocr (BLACK/BLUE/RED): ");Color cor = Color.valueOf(sc.next());

            if (tipoShape == 'r'){
                System.out.printf("Width: "); double width = sc.nextDouble();
                System.out.printf("Height: "); double height = sc.nextDouble();
                shapeList.add(new Rectangle(cor,width, height));
            }
            else if (tipoShape == 'c'){
                System.out.printf("Radius: "); double radius = sc.nextDouble();
                shapeList.add(new Circle(cor,radius));
            }
        }
    }
}

abstract class Shape{

    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract Double area();

}

class Circle extends Shape{

    private Double radius;

    public Circle(Color cor,Double radius) {
        super(cor);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}

class Rectangle extends Shape{

    private Double width;
    private Double height;


    public Rectangle(Color cor,Double width, Double height) {
        super(cor);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public Double area() {
        return getHeight() * getWidth();
    }
}

enum Color {

    BLACK,
    BLUE,
    RED;

}

