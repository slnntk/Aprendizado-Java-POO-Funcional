package beecrowd;

import java.io.IOException;
import java.util.Scanner;
public class D1131 {

    public static void main(String[] args) throws IOException {
        new Torneio();
    }
}

class Torneio{

    public  Torneio() {
        Scanner  sc = new Scanner(System.in);
        Grenal[] vetorGrenal = new Grenal[1];
        Placar placarGrenal = new Placar();
        FabricaDeGrenais(vetorGrenal, sc, placarGrenal);
        placarGrenal.Relatorio();
    }
    public void FabricaDeGrenais(Grenal[] vetorGrenal, Scanner sc, Placar placarGrenal){
        int n = 1;
        do{
            vetorGrenal[0]  = new Grenal(sc.nextInt(), sc.nextInt());
            System.out.println("Novo grenal (1-sim 2-nao)");
            n = sc.nextInt();
            placarGrenal.setQtdClassicos(placarGrenal.getQtdClassicos()+1);
            if (vetorGrenal[0].getGolsInter() > vetorGrenal[0].getGolsGremio()){
                placarGrenal.setQtdVInter(placarGrenal.getQtdVInter()+1);
            }
            else if (vetorGrenal[0].getGolsGremio() > vetorGrenal[0].getGolsInter()){
                placarGrenal.setQtdVGremio(placarGrenal.getQtdVGremio()+1);
            }
            else if (vetorGrenal[0].getGolsInter() == vetorGrenal[0].getGolsGremio()){
                placarGrenal.setQtdEmpates(placarGrenal.getQtdEmpates()+1);
            }
        } while (n == 1);
    }
}

class Placar{

    private int qtdClassicos;
    private int qtdVInter;
    private int qtdVGremio;
    private int qtdEmpates;

    public String maiorVencedor(){
        if (getQtdVInter() > getQtdVGremio()){
            return  "Inter venceu mais";
        }
        else if (getQtdVGremio() > getQtdVInter()){
            return "Gremio venceu mais";
        }
        else{
            return "Nao houve vencedor";
        }
    }
    public void Relatorio() {
        System.out.printf("%d grenais%n", getQtdClassicos());
        System.out.printf("Inter:%d%n", getQtdVInter());
        System.out.printf("Gremio:%d%n", getQtdVGremio());
        System.out.printf("Empates:%d%n", getQtdEmpates());
        System.out.println(maiorVencedor());
    }

    public int getQtdClassicos() {
        return qtdClassicos;
    }

    public void setQtdClassicos(int qtdClassicos) {
        this.qtdClassicos = qtdClassicos;
    }

    public int getQtdVInter() {
        return qtdVInter;
    }

    public void setQtdVInter(int qtdVInter) {
        this.qtdVInter = qtdVInter;
    }

    public int getQtdVGremio() {
        return qtdVGremio;
    }

    public void setQtdVGremio(int qtdVGremio) {
        this.qtdVGremio = qtdVGremio;
    }

    public int getQtdEmpates() {
        return qtdEmpates;
    }

    public void setQtdEmpates(int qtdEmpates) {
        this.qtdEmpates = qtdEmpates;
    }
}

class Grenal{

    private int golsInter;
    private int golsGremio;

    public Grenal(int golsInter, int golsGremio) {
        setGolsInter(golsInter);
        setGolsGremio(golsGremio);
    }

    public int getGolsInter() {
        return golsInter;
    }

    public void setGolsInter(int golsInter) {
        this.golsInter = golsInter;
    }

    public int getGolsGremio() {
        return golsGremio;
    }

    public void setGolsGremio(int golsGremio) {
        this.golsGremio = golsGremio;
    }
}