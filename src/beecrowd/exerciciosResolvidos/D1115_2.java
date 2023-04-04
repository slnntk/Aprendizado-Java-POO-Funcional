package beecrowd.exerciciosResolvidos;

import javax.swing.*;
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
        this.X  = new Ponto("X", sc.nextInt());
        this.Y  = new Ponto("Y", sc.nextInt());
        System.out.println(getQuadrante());
    }

    public Ponto getX() {
        return X;
    }

    public String getQuadrante() {
        return new Quadrante(X, Y).getNomeQuadrante();
    }

}

class Ponto{

    private Eixo eixo;
    private int numberPoint;

    public Ponto() {

    }

    public Ponto(String eixo, int numberPoint) {
        this.numberPoint = numberPoint;
        this.eixo = new Eixo(eixo);
    }

    public int getNumberPoint() {
        return numberPoint;
    }

    public String getEixo() {
        return eixo.getEixo();
    }

}

class Quadrante{

    private String nomeQuadrante;
    private Ponto x;
    private Ponto y;

    public Quadrante(Ponto x, Ponto y) {
        this.x = x;
        this.y = y;
        searchQuadrante();
    }

    public void searchQuadrante() {
        if (x.getNumberPoint() > 0 && y.getNumberPoint() > 0) {
            this.nomeQuadrante = "primeiro";
        } else if (x.getNumberPoint() < 0 && y.getNumberPoint() > 0) {
            this.nomeQuadrante = "segundo";
        } else if (x.getNumberPoint() < 0 && y.getNumberPoint() < 0) {
            this.nomeQuadrante = "terceiro";
        } else if (x.getNumberPoint() > 0 && y.getNumberPoint() < 0) {
            this.nomeQuadrante = "quarto";
        } else {
            this.nomeQuadrante = "origem";
        }
    }

    public String getNomeQuadrante() {
        return nomeQuadrante;
    }
}

class Eixo{

    private String eixo;

    public Eixo(String eixo) {
        this.eixo = eixo;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }
}




