package rascunhos;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FabricanteDeBlusas fabricanteDeBlusas = new FabricanteDeBlusas(sc);
        sc.close();
    }
}

class FabricanteDeBlusas {

    List<Pessoa> compradorList = new ArrayList<>();

    public FabricanteDeBlusas(Scanner sc) {
        addCompradores(sc);
    }

    public List<Pessoa> getCompradorList() {
        return compradorList;
    }

    public void addCompradores(Scanner sc) {

        int n = sc.nextInt();
        sc.nextLine();
        while (n != 0){
            for (int i = 0; i < n; i++) {
                String[] nome = sc.nextLine().split(" ");
                String[] corAndTamanho = sc.nextLine().split(" ");
                compradorList.add(new Pessoa(nome, new Camisa(corAndTamanho)));
            }
            imprimirCompradores();
            compradorList.clear();
            n = sc.nextInt();
            sc.nextLine();
        }
    }


    public void imprimirCompradores() {
        Collections.sort(compradorList);
        for (Pessoa comprador : compradorList) {
            System.out.println(comprador.getCamisa().getCor() +
                    " " + comprador.getCamisa().getTamanho() +
                    " " + comprador.getName());
        }
        System.out.println();
    }
}

class Camisa {

    private final String cor;
    private final String tamanho;

    public Camisa(String[] corAndTamanho) {
        this.cor = corAndTamanho[0].toLowerCase();
        this.tamanho = corAndTamanho[1].toUpperCase();
    }

    public String getCor() {
        return cor;
    }

    public String getTamanho() {
        return tamanho;
    }

}

class Pessoa implements Comparable<Pessoa> {

    private final Camisa camisa;
    private String name;

    public Pessoa(String[] name, Camisa camisa) {
        this.name = name[0];
        for (int i = 1;i < name.length;i++){
            this.name += " " + name[i];
        }
        this.camisa = camisa;
    }

    public Camisa getCamisa() {
        return camisa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Pessoa o) {
        // Comparação por cor da camisa em ordem ascendente
        int result = camisa.getCor().compareTo(o.getCamisa().getCor());

        // Se as cores forem iguais, comparar por tamanho da camisa em ordem descendente
        if (result == 0) {
            result = o.getCamisa().getTamanho().compareTo(camisa.getTamanho());
        }

        // Se as cores e tamanhos forem iguais, comparar por nome em ordem ascendente
        if (result == 0) {
            result = name.compareTo(o.getName());
        }

        return result;
    }

}
