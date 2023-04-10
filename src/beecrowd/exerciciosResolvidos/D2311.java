package beecrowd.exerciciosResolvidos;

import java.util.*;

public class D2311 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new Competicao();
    }
}

class Competicao{

    private List<Atleta> atletaList = new ArrayList<>();

    public Competicao() {
        Scanner sc = new Scanner(System.in);
        int nCompetidores = sc.nextInt();
        saltosDosAtletas(sc, nCompetidores);
        calcularNota(atletaList);
    }

    public void saltosDosAtletas(Scanner sc, int nCompetidores){
        for (int i = 0;i < nCompetidores;i++){
            String nome = sc.next();
            double dificuldade = sc.nextDouble();
            double[] notas = new double[7];
            for (int j = 0;j < 7;j++){
                notas[j] = sc.nextDouble();
            }
            atletaList.add(new Atleta(nome, dificuldade, notas));
        }
    }

    public void calcularNota(List<Atleta> atletaList){
        for(Atleta atleta : atletaList){
            double k = 0;
            double[] saltosOrdenados = Arrays.stream(atleta.getSaltos()).sorted().toArray();
            for(int i = 1; i < 6;i++){
                k += saltosOrdenados[i];
            }
            System.out.printf("%s %.2f%n", atleta.getNome(), k * atleta.getDificuldade());
        }
    }
}

class Atleta {

    private String nome;
    private double dificuldade;
    private double[] saltos;

    public Atleta(String nome, double dificuldade, double[] saltos) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.saltos = saltos;
    }

    public String getNome() {
        return nome;
    }

    public double getDificuldade() {
        return dificuldade;
    }

    public double[] getSaltos() {
        return saltos;
    }

    public void setSaltos(int indice, double saltos) {
        this.saltos[indice] = saltos;
    }
}