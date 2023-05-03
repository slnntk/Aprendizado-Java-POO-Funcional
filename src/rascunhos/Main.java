package rascunhos;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        Triangulo t = new Triangulo(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        if (t.getLado1() < t.getLado2() + t.getLado3() && t.getLado2() < t.getLado3() + t.getLado1() && t.getLado3() < t.getLado1() + t.getLado2()) {
            System.out.println("Perimetro = " + t.perimetro());
        } else {
            System.out.println("Area = " + t.area());
        }
    }
}


class Triangulo implements Forma{
    double lado1;
    double lado2;
    double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double area() {
        return ((lado1 + lado2) * lado3) / 2;
    }

    @Override
    public double perimetro() {
        return lado1 + lado2 + lado3;
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
}



interface Forma{
     double area() ;

     double perimetro();
}
