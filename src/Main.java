import java.util.Scanner;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Transportes transportes = new Transportes();

        while (true) {
            String comando = sc.next();
            if (comando.equals("ABEND")) {
                sc.close();
                break;
            }

            int pessoas = sc.nextInt();
            if (comando.equalsIgnoreCase("SALIDA")) {
                transportes.adicionarSaida(pessoas);
            } else if (comando.equalsIgnoreCase("VUELTA")) {
                transportes.adicionarVolta(pessoas);
            }
        }

        System.out.println(transportes.getPessoasFaltantes());
        System.out.println(transportes.getTransportesFaltantes());
    }
}

class Transportes {

    private int qtdSaidas;
    private int qtdVoltas;
    private int qtdPessoas;

    public void adicionarSaida(int qtdPessoas) {
        this.qtdSaidas++;
        this.qtdPessoas -= qtdPessoas;
    }

    public void adicionarVolta(int qtdPessoas) {
        this.qtdVoltas++;
        this.qtdPessoas += qtdPessoas;
    }

    public int getPessoasFaltantes() {
        return Math.abs(qtdPessoas);
    }

    public int getTransportesFaltantes() {
        return Math.abs(qtdSaidas - qtdVoltas);
    }
}
