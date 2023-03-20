package rascunhos;

import java.util.Scanner;

public class PESSOASEIDADE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Cadastrador(sc, sc.nextInt());
    }
}

class Relatorio{

    public Relatorio(Pessoa[] p) {

        int maior = 0;
        String maioridade = "";
        for (int i = 0;i < p.length;i++){

            if (p[i].getIdadee() >= maior){
                maior = p[i].getIdadee();
                maioridade = p[i].getNome();
            }
        }
        System.out.printf("A maior idade pertence a: %s com %d anos", maioridade, maior );
    }
}

class Cadastrador{

    public Cadastrador(Scanner sc, int numerodepessoas) {

        Pessoa[] vetorPessoas = new Pessoa[numerodepessoas];
        for (int i = 0;i < numerodepessoas;i++){
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            vetorPessoas[i] = new Pessoa(nome, idade);
        }
    new Relatorio(vetorPessoas);
    }
}

class Pessoa{

    private String nome;
    private int idadee;

    public Pessoa(String nome, int idadee) {
        setNome(nome);
        setIdadee(idadee);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdadee() {
        return idadee;
    }

    public void setIdadee(int idadee) {
        this.idadee = idadee;
    }
}
