package rascunhos;

import java.util.Scanner;

public class D1061 {
    public static void main(String[] args) {
        new PulaSapo();
    }
}

class PulaSapo{
    public PulaSapo() {
        Scanner sc = new Scanner(System.in);
        Sapo s = new Sapo(sc.nextInt());
        int n = sc.nextInt();
        result(gameFinish(pularCanos(s.getSaltoMax(), sc, n)));
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

    public boolean pularCanos(int puloSapo, Scanner sc, int n){
        boolean jumping = true;
        Cano anterior = new Cano(sc.nextInt());
        for (int i = 1;i < n;i++){
            Cano c = new Cano(sc.nextInt());
            if (!canJump(anterior.getAltura(), c.getAltura(), puloSapo)){
                jumping = false;
                break;
            }
            anterior = c;
        }
        return jumping;
    }

    public boolean canJump(int anterior, int cano, int puloSapo){
        if (Math.abs(cano - anterior) <= puloSapo){
            return true;
        }
        else{
            return false;
        }
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
    private int saltoMax;

    public Sapo(int saltoMax) {
        super(0);
        this.saltoMax = saltoMax;
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


