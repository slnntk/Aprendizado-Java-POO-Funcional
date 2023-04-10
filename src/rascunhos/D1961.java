package rascunhos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1961 {
    public static void main(String[] args) throws IOException {
        new Jogo();
    }
}

class Jogo{
    public Jogo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        ObjetoDoJogo s = new Sapo(Integer.parseInt(input[0]));
        int n = Integer.parseInt(input[1]);
        result(gameFinish(pularCanos(br, n, (Sapo) s)));
        br.close();
    }

    public boolean pularCanos(BufferedReader br, int n, Sapo s) throws IOException {
        String[] alturas = br.readLine().split(" ");
        ObjetoDoJogo anterior = criarCano(Integer.parseInt(alturas[0]));
        for (int i = 1; i < n; i++) {
            ObjetoDoJogo atual = criarCano(Integer.parseInt(alturas[i]));
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
        return jumping ? "YOU WIN" : "GAME OVER";
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
