import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Resultado(new Partida(sc));
        sc.close();
        System.out.println("teste");
    }
}

class Jogador{

    private String nome;
    private int pontos;

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

}

class Round {
    private Jogador jogador1;
    private Jogador jogador2;
    private String vencedor;

    public Round(Scanner sc){
        this.jogador1 = criarJogador("JOAO", sc);
        this.jogador2 = criarJogador("MARIA", sc);
        this.vencedor = determinarVencedor();
        System.out.println(getVencedor());
    }

    private Jogador criarJogador(String nome, Scanner sc) {
        int pontos = 0;
        for(int i = 0; i < 3; i++){
            pontos += sc.nextInt() * sc.nextInt();
        }
        return new Jogador(nome, pontos);
    }

    private String determinarVencedor() {
        if (jogador1.getPontos() >= jogador2.getPontos()){
            return jogador1.getNome();
        } else {
            return jogador2.getNome();
        }
    }

    public String getVencedor() {
        return vencedor;
    }
}

class Partida{

    private Round[] rounds;

    public Partida(Scanner sc){
        int n = sc.nextInt();
        rounds = new Round[n];
        for (int i = 0;i < n;i++){
            rounds[i] = new Round(sc);
        }
    }

    public Round[] getRounds() {
        return rounds;
    }
}

class Resultado {

    private Partida partida;
    private int joaovitorias = 0;
    private int mariavitorias = 0;

    public Resultado(Partida partida) {
        this.partida = partida;
        for (Round round : partida.getRounds()) {
            if (round.getVencedor().equals("JOAO")){
                joaovitorias += 1;
            }
            else{
                mariavitorias += 1;
            }
        }
        //System.out.println(getResultado());//
    }

    public String getResultado() {
        if (joaovitorias > mariavitorias){
            return "JOAO";
        }
        else if (joaovitorias < mariavitorias){
            return "MARIA";
        }
        else{
            return "EMPATE";
        }
    }
}
