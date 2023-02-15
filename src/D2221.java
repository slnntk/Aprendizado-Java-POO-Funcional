import java.io.IOException;
import java.util.Scanner;

public class D2221 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nBatalhas = sc.nextInt();

        for (int i = 0;i < nBatalhas;i++){
            int bonus = sc.nextInt();
            Poke p1 = new Poke(sc.nextInt(), sc.nextInt(), sc.nextInt(), bonus);
            Poke p2 = new Poke(sc.nextInt(), sc.nextInt(), sc.nextInt(), bonus);
            Jogador j = new Jogador();
            System.out.println(j.calculoBatalha(p1, p2));
        }
    }
}

class Jogador{

    private String nome1;
    private String nome2;

    public Jogador() {

        setNome1("Dabriel");
        setNome2("Guarte");

    }

    public String calculoBatalha(Poke p1, Poke p2){
        int v1 = 0;
        int v2 = 0;

        v1 = ((p1.getAtaque() + p1.getDefesa()) / 2) + (p1.getLevel() % 2 == 0 ? p1.getBonus() : 0);
        v2 = ((p2.getAtaque() + p2.getDefesa()) / 2) + (p2.getLevel() % 2 == 0 ? p1.getBonus() : 0);

        if (v1 == v2){
            return "Empate";
        }
        else if (v2 > v1){
            return getNome2();
        }
        else {
            return getNome1();
        }
    }

    public String getNome1() {
        return nome1;
    }

    public void setNome1(String nome1) {
        this.nome1 = nome1;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }
}

class Poke {

    private int ataque;
    private int defesa;
    private int level;
    private int bonus;

    public Poke(int ataque, int defesa, int level, int bonus) {
        setAtaque(ataque);
        setDefesa(defesa);
        setLevel(level);
        setBonus(bonus);
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}