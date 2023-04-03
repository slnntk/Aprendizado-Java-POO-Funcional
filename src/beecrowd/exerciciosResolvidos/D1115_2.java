package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1115_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new FabricaDeQuadrantes(sc);
    }
}

class FabricaDeQuadrantes{

    public FabricaDeQuadrantes(Scanner sc) {
        int X, Y;

        do{
            X = sc.nextInt();
            Y = sc.nextInt();
            new Coordenada(X, Y);
        } while (X != 0 && Y != 0);
        sc.close();
    }
}

class Coordenada extends Ponto{

    private final Ponto X;
    private final Ponto Y;

    public Coordenada(int X, int Y) {
        super();
        this.X  = new Ponto(X);
        this.Y  = new Ponto(Y);
        getQuadrante();
    }

    public Ponto getX() {
        return X;
    }

    public void getQuadrante() {
        new Quadrante(X.getNumberPoint(), Y.getNumberPoint());
    }

}

class Ponto{

    private int numberPoint;

    public Ponto() {

    }

    public Ponto(int numberPoint) {
        this.numberPoint = numberPoint;
    }

    public int getNumberPoint() {
        return numberPoint;
    }
}

class Quadrante{

    private final int X;
    private final int Y;

    public Quadrante(int x, int y) {
        this.X = x;
        this.Y = y;
        getNomeQuadrante();
    }

    public void getNomeQuadrante() {
        if (X > 0 & Y > 0){
            System.out.println("primeiro");
        }
        else if (X < 0 & Y > 0){
            System.out.println("segundo");
        }
        else if (X < 0 & Y < 0){
            System.out.println("terceiro");
        }
        else if (X > 0 & Y < 0){
            System.out.println("quarto");
        }
    }
}



