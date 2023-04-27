package rascunhos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Triangulo t = new Triangulo(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        double[] ladosTriangulo = {t.getLado1(), t.getLado2(), t.getLado3()};
        calcular(ladosTriangulo, t);
    }

    public static void calcular(double vetor[], Triangulo t){
        if ((vetor[0] < (float)(vetor[1]+vetor[2])) && (vetor[1] < (float)(vetor[0]+vetor[2])) && (vetor[2] < (float)(vetor[1]+vetor[0]))){
            System.out.printf("Perimetro = %.1f\n", t.perimetro(vetor));
        }
        else {
            System.out.printf("Area = %.1f\n", t.area(vetor));
        }
    }
}


interface Forma{

     double area(double[] vetor);
     double perimetro(double[] vetor);

}

class Triangulo implements Forma{

    private final double lado1;
    private final double lado2;
    private final double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public String toString() {
        return String.valueOf(lado1 + "\n" + lado2 + "\n" + lado3);
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

    @Override
    public double area(double[] vetor) {
        return ((vetor[0] + vetor[1]) * vetor[2]) / 2;
    }

    @Override
    public double perimetro(double[] vetor) {
        return vetor[1] + vetor[2] + vetor[0];
    }
}
