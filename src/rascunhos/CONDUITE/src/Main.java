import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new FabricaDeConduites();
    }
}

class RelatorioC{

    public RelatorioC(double raioC) {
        System.out.printf("%.0f%n", raioC);
    }
}

class FabricaDeConduites {

    public FabricaDeConduites() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Conduite[] vetorConduites = new Conduite[n];
        for(int i = 0; i < n; i++) {
            double raio1 = sc.nextDouble();
            double raio2 = sc.nextDouble();
            vetorConduites[i] = new Conduite(raio1, raio2);
            new RelatorioC(vetorConduites[i].getRai oConduite());
        }
    }
}


class Conduite {

    private double raio1;
    private double raio2;

    public Conduite(double raio1, double raio2) {
        setRaio1(raio1);
        setRaio2(raio2);
    }

    public double getRaio1() {
        return raio1;
    }

    public void setRaio1(double raio1) {
        this.raio1 = raio1;
    }

    public double getRaio2() {
        return raio2;
    }

    public void setRaio2(double raio2) {
        this.raio2 = raio2;
    }

    public double getRaioConduite() {
        return raio1 + raio2;
    }
}


class Cabos{

    private double raio;

    public Cabos(double raio) {
        setRaio(raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}