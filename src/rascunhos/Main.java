package rascunhos;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Triangulo t = new Triangulo();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        t.setLado1(sc.nextDouble());
        t.setLado2(sc.nextDouble());
        t.setLado3(sc.nextDouble());

        if (t.getLado1() < t.getLado2() + t.getLado3() && t.getLado2() < t.getLado3() + t.getLado1() && t.getLado3() < t.getLado1() + t.getLado2()) {
            t.perimetro();
        } else {
            t.area();
        }
    }
}
class Triangulo{

    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo() {
    }

    public void area(){
         double area = ((lado1 + lado2) * lado3)/2;
        System.out.printf("Area = %.2f\n", area);
    }

    public void perimetro(){
        double perimetro = lado1 + lado2 + lado3;
        System.out.printf("Perimetro = %.2f\n", perimetro);
    }


    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
}

