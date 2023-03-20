package beecrowd;

import java.io.IOException;
import java.util.Scanner;

public class D2310 {

    public static void main(String[] args) throws IOException {
        new Estatistica();
    }
}

class Estatistica{
    public Estatistica() {
        Time Volei = new Time();
        RelatorioFinal(Volei);
        }

    public void RelatorioFinal(Time v){
        String[] resultadosString = {"Saque", "Bloqueio", "Ataque"};
        // Calcula o percentual de saques [0]
        // Calcula o percentual de bloqueios [1]
        // Calcula o percentual de ataques [2]
        for(int i = 0;i < 3;i++){
            double temporario;
            temporario = (double) v.getAcertosTime(i) / v.getTentativasTime(i) * 100.0;
            System.out.printf("Pontos de %s: %.2f %%.%n", resultadosString[i], temporario);
        }
    }
}

class Time{

    private int[] tentativasTime;
    private int[] acertosTime;

    public Time() {
        Scanner  sc = new Scanner(System.in);
        tentativasTime = new int[3];
        acertosTime = new int[3];
        int nJogadores = sc.nextInt();
        CadastrarJogadores(nJogadores, sc);
    }

    public void CadastrarJogadores(int nJogadores, Scanner sc){
        for (int i = 0; i < nJogadores; i++) {
            String nome = sc.next();
            int[] tentativas = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int[] acertos = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            Jogador jogador = new Jogador(nome, tentativas, acertos);
            for (int j = 0; j < 3; j++) {
                setTentativasTime(j, jogador.getTentativas( j));
                setAcertosTime(j, jogador.getAcertos(j));
            }
        }
    }

    public int getTentativasTime(int indice) {
        return tentativasTime[indice];
    }

    public void setTentativasTime(int indice, int tentativas) {
        this.tentativasTime[indice]  += tentativas;
    }

    public int getAcertosTime(int indice) {
        return acertosTime[indice];
    }

    public void setAcertosTime(int indice, int acertos) {
        this.acertosTime[indice] += acertos;
    }
}

class Jogador{

    private String nome;
    private int[] tentativas;
    private int[] acertos;

    public Jogador(String nome, int[] tentativasRecebida, int[] acertosRecebida) {
        this.tentativas = new int[3];
        this.acertos = new int[3];
        this.nome = nome;
        for(int i = 0;i < 3;i++){
            setTentativas(i, tentativasRecebida[i]);
            setAcertos(i, acertosRecebida[i]);
        }
    }

    public int getTentativas(int indice) {
        return tentativas[indice];
    }

    public void setTentativas(int indice, int tentativas) {
        this.tentativas[indice] = tentativas;
    }

    public int getAcertos(int indice) {
        return acertos[indice];
    }

    public void setAcertos(int indice, int acertos) {
        this.acertos[indice] = acertos;
    }
}
