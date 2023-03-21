package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D2708_2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Relatorios r = new Relatorios();

        while (true){
            String comando = sc.next();
            if (comando.equals("ABEND")){
                sc.close();
                break;
            }
            int pessoas = sc.nextInt();
            if (comando.equals("SALIDA")){
                r.Saida(pessoas);
            }
            else if (comando.equals("VUELTA")){
                r.Entrada(pessoas);
            }
        }
        System.out.printf("%d%n%d%n", Math.abs(r.getQtdPessoas()), r.getQtdEntradas()-r.getQtdSaidas());
    }
}

class Relatorios{

    private int qtdSaidas;
    private int qtdEntradas;
    private int qtdPessoas;

    public void Saida(int qtdPessoas){
        setQtdSaidas(+1);
        setQtdPessoas(getQtdPessoas()-qtdPessoas);
    }

    public void Entrada(int qtdPessoas){
        setQtdEntradas(+1);
        setQtdPessoas(getQtdPessoas()+qtdPessoas);
    }

    public int getQtdSaidas() {
        return qtdSaidas;
    }

    public void setQtdSaidas(int qtdSaidas) {
        this.qtdSaidas = qtdSaidas;
    }

    public int getQtdEntradas() {
        return qtdEntradas;
    }

    public void setQtdEntradas(int qtdEntradas) {
        this.qtdEntradas = qtdEntradas;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
}
