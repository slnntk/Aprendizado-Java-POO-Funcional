package beecrowd.exerciciosResolvidos;

public class D1115_2 {
    public static void main(String[] args) {

    }
}

class Coordenada{

    private Ponto X;
    private Ponto Y;

    public Coordenada(int x, int y) {
        X = new Ponto(x);
        Y = new Ponto(y);
    }

    public Ponto getX() {
        return X;
    }

    public void setX(Ponto x) {
        X = x;
    }

    public Ponto getY() {
        return Y;
    }

    public void setY(Ponto y) {
        Y = y;
    }
}

class Ponto extends Coordenada{

    private int numberPoint;

    public Ponto(int x, int y, int numberPoint) {
        super(x, y);
        this.numberPoint = numberPoint;
    }

    public int getNumberPoint() {
        return numberPoint;
    }

    public void setNumberPoint(int numberPoint) {
        this.numberPoint = numberPoint;
    }
}

class Quadrante{

    private int x;
    private int y;


    
}



