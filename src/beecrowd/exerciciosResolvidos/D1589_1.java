package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1589_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCasos = sc.nextInt();
        for (int i = 0; i < nCasos; i++) {
            int raio1 = sc.nextInt();
            int raio2 = sc.nextInt();
            CasoDeTeste caso = new CasoDeTeste(raio1, raio2);
            int raioConduite = caso.calcularRaioConduite();
            Resultado resultado = new Resultado(raioConduite);
            resultado.exibirResultado();
        }
        sc.close();
    }
}

class CasoDeTeste {
    private int raio1;
    private int raio2;

    public CasoDeTeste(int raio1, int raio2) {
        this.raio1 = raio1;
        this.raio2 = raio2;
    }

    public int calcularRaioConduite() {
        return raio1 + raio2;
    }

    public int getRaio1() {
        return raio1;
    }

    public int getRaio2() {
        return raio2;
    }
}

class Resultado {
    private int raioConduite;

    public Resultado(int raioConduite) {
        this.raioConduite = raioConduite;
    }

    public void exibirResultado() {
        System.out.println(raioConduite);
    }
}