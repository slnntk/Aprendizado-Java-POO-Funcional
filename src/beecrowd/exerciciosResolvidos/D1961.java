package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1961 {
    public static void main(String[] args) {
        new JogoDoSapo();
    }
}

class JogoDoSapo{
    public JogoDoSapo() {
        Scanner sc = new Scanner(System.in);
        Sapo s = new Sapo(sc.nextInt());
        int n = sc.nextInt();
        result(gameFinish(s.pularCanos(sc, n)));
        sc.close();
    }

    public void result(String result){
        System.out.println(result);
    }

    public String gameFinish(boolean jumping){
        String temp;
        if (jumping){
            temp = "YOU WIN";
        }
        else{
            temp = "GAME OVER";
        }
        return temp;
    }

}

class ObjetoDoJogo {
    protected int altura;

    public ObjetoDoJogo(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

}


class Sapo extends ObjetoDoJogo {
    private final int saltoMax;

    public Sapo(int saltoMax) {
        super(0);
        this.saltoMax = saltoMax;
    }

    public boolean pularCanos(Scanner sc, int n){
        boolean jumping = true;
        Cano anterior = new Cano(sc.nextInt());
        for (int i = 1;i < n;i++){
            Cano c = new Cano(sc.nextInt());
            if (!canJump(anterior.getAltura(), c.getAltura())){
                jumping = false;
                break;
            }
            anterior = c;
        }
        return jumping;
    }

    public boolean canJump(int anterior, int cano){
        if (Math.abs(cano - anterior) <= saltoMax){
            return true;
        }
        else{
            return false;
        }
    }

    public int getSaltoMax() {
        return saltoMax;
    }
}

class Cano extends ObjetoDoJogo {
    public Cano(int altura) {
        super(altura);
    }
}


