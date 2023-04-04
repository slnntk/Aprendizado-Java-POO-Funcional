package rascunhos;

import java.util.Scanner;

public class D1961 {
    public static void main(String[] args) {
        new Jogo();
    }
}

class Jogo{
    public Jogo() {
        Scanner sc = new Scanner(System.in);
        ObjetoDoJogo s = new Sapo(sc.nextInt());
        int n = sc.nextInt();
        result(gameFinish(pularCanos(sc, n, (Sapo) s)));
        sc.close();
    }

    public boolean pularCanos(Scanner sc, int n, Sapo s) {
        ObjetoDoJogo anterior = criarCano(sc.nextInt());
        for (int i = 1; i < n; i++) {
            ObjetoDoJogo atual = criarCano(sc.nextInt());
            if (!s.canJump(anterior.getAltura(), atual.getAltura())) {
                return false;
            }
            anterior = atual;
        }
        return true;
    }

    public ObjetoDoJogo criarCano(int altura){
        return new Cano(altura);
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

    public boolean canJump(int anterior, int cano) {
        return Math.abs(cano - anterior) <= saltoMax;
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