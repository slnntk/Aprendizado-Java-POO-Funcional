import java.util.Scanner;

public class D1589_REFEITA {
    public static void main(String[] args) {
        new FabricaDeConduites();
    }
}

class RelatorioC{

    public RelatorioC(double raioC) {
        System.out.println(raioC);
    }
}

class FabricaDeConduites{

    public FabricaDeConduites() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Conduite[] vetorConduites = new Conduite[n];
        for(int i = 0;i < n;i++){
            vetorConduites[i] = new Conduite(sc, sc.nextInt());
            new RelatorioC(vetorConduites[i].getRaioConduite());
        }
    }
}

class Conduite{

    private double raioConduite;

    public Conduite(Scanner sc, int n) {
        Cabos[] vetorCabos = new Cabos[n];
        for (int i = 0;i < n;i++){
            vetorCabos[i] = new Cabos(sc.nextInt());
            setRaioConduite(vetorCabos[i].getRaio()+getRaioConduite());
        }
    }

    public double getRaioConduite() {
        return raioConduite;
    }

    public void setRaioConduite(double raioConduite) {
        this.raioConduite = raioConduite;
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