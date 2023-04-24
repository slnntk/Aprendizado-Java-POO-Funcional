package beecrowd.exerciciosResolvidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D1961 {
    public static void main(String[] args) {
        Game game = new Game();
    }
}

class Game implements GameInterface{
    Scanner sc = new Scanner(System.in);
    private Sapo sapo;
    List<Integer> integerList = new ArrayList<>();

    public Game() {
        int salto = sc.nextInt();
        int n = sc.nextInt();
        this.sapo = new Sapo(salto);
        gameFinish(gaming(n));
    }


    public boolean jumping(int anterior, int atual) {
        return Math.abs(atual - anterior) <= sapo.getSaltoMax();
    }

    @Override
    public boolean gaming(int n) {
        int i;
        for (i = 0;i < n;i++){
            integerList.add(sc.nextInt());
        }
        i = 1;
        boolean result = true;
        while (i < n){
            result = jumping(integerList.get(i), integerList.get(i-1));
            if (!result){
                return false;
            }
            i++;
        }
        return result;
    }
    @Override
    public void gameFinish(boolean jumping) {
        System.out.println(jumping ? "YOU WIN" : "GAME OVER");
    }
}

interface GameInterface{

    boolean jumping(int anterior, int atual);
    boolean gaming(int n);
    public void gameFinish(boolean jumping);

}


class Sapo{

    private int saltoMax;

    public Sapo(int saltoMax) {
        this.saltoMax = saltoMax;
    }

    public int getSaltoMax() {
        return saltoMax;
    }
}
