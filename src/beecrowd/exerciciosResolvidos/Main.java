package beecrowd.exerciciosResolvidos;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Treinamento treino = new Treinamento();
        treino.addCandidatos(sc.nextInt(), sc);
        treino.printCadidatos();

    }
}

class Treinamento implements TreinamentoInterface{

    List<Integer> list = new ArrayList<>();

    @Override
    public void addCandidatos(int n, Scanner sc) {
        for (int i = 0;i < n;i++){
            list.add(sc.nextInt());
        }
        list.removeIf(x -> x < 1);
    }

    @Override
    public void printCadidatos() {
        System.out.printf("%d%n", list.size());
    }
}

interface TreinamentoInterface{
    void addCandidatos(int n, Scanner sc);

    void printCadidatos();
}