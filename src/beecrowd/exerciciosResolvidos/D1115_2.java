package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1115_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Coordenada(sc);
    }
}

class Coordenada extends Ponto{

    private final Ponto X;
    private final Ponto Y;

    public Coordenada(Scanner sc) {
        super();
        this.X  = new Ponto(sc.nextInt());
        this.Y  = new Ponto(sc.nextInt());
        System.out.println(getQuadrante());
    }

    public Ponto getX() {
        return X;
    }

    public String getQuadrante() {
        return new Quadrante(X.getNumberPoint(), Y.getNumberPoint()).getNomeQuadrante();
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

    private String nomeQuadrante;
    private int x;
    private int y;

    public Quadrante(int x, int y) {
        this.x = x;
        this.y = y;
        searchQuadrante();
    }

    public void searchQuadrante() {
        if (x > 0 && y > 0) {
            this.nomeQuadrante = "primeiro";
        } else if (x < 0 && y > 0) {
            this.nomeQuadrante = "segundo";
        } else if (x < 0 && y < 0) {
            this.nomeQuadrante = "terceiro";
        } else if (x > 0 && y < 0) {
            this.nomeQuadrante = "quarto";
        } else {
            this.nomeQuadrante = "origem";
        }
    }

    public String getNomeQuadrante() {
        return nomeQuadrante;
    }
}



