package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D2221 {
    public static void main(String[] args)  throws IOException  {
        Scanner sc = new Scanner(System.in);
        new TorneioPokemon(sc);
        sc.close();
    }
}

class TorneioPokemon{

    public TorneioPokemon(Scanner sc) {
        int nBatalhas = sc.nextInt();
        BatalhaPokemon[] vetorBatalha = new BatalhaPokemon[nBatalhas];
        for(int i = 0;i < nBatalhas;i++){
            vetorBatalha[i] = new BatalhaPokemon(sc);
        }
    }
}

class BatalhaPokemon{

    public BatalhaPokemon(Scanner sc) {
        Pokemon[] vetorPokemon = new Pokemon[2];
        int bonus = sc.nextInt();
        vetorPokemon[0] = new Pokemon("Dabriel",sc.nextInt(), sc.nextInt(), sc.nextInt(), bonus);
        vetorPokemon[1] = new Pokemon("Guarte",sc.nextInt(), sc.nextInt(), sc.nextInt(), bonus);
        resulucao(vetorPokemon);
    }

    public void resulucao(Pokemon[] vetor){

        if (vetor[0].getLevel() % 2 != 0){
            vetor[0].setBonus(0);
        }
        if (vetor[1].getLevel() % 2 != 0){
            vetor[1].setBonus(0);
        }

        if (((vetor[0].getAtaque() + vetor[0].getDefesa())/2) + vetor[0].getBonus() > ((vetor[1].getAtaque() + vetor[1].getDefesa())/2) + vetor[1].getBonus()){
            System.out.println(vetor[0].getnomeTreinador());
        }

        else if (((vetor[0].getAtaque() + vetor[0].getDefesa())/2) + vetor[0].getBonus() < ((vetor[1].getAtaque() + vetor[1].getDefesa())/2) + vetor[1].getBonus()){
            System.out.println(vetor[1].getnomeTreinador());
        }

        else{
            System.out.println("Empate");
        }
    }


}

class Pokemon{

    private final String nomeTreinador;
    private int ataque;
    private int defesa;
    private int level;
    private int bonus;

    public Pokemon(String nomeTreinador, int ataque, int defesa, int level, int bonus) {
        setAtaque(ataque);
        setDefesa(defesa);
        setLevel(level);
        setBonus(bonus);
        this.nomeTreinador = nomeTreinador;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getnomeTreinador() {
        return nomeTreinador;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
