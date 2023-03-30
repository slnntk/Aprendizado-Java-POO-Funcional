package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1049_2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Reino reino = new Reino(sc);
        Filo filo = new Filo(sc, reino);
        Classe classe = new Classe(sc, filo);
        Ordem ordem = new Ordem(sc, classe);
        Genero genero = new Genero(sc, ordem);

        System.out.println(genero.getNome());
    }
}

class Reino {
    private String nome;

    public Reino(Scanner sc) {
        this.nome = sc.next();
    }

    public String getNome() {
        return nome;
    }
}

class Filo {
    private String nome;

    public Filo(Scanner sc, Reino reino) {
        String input = sc.next();
        if (reino.getNome().equalsIgnoreCase("vertebrado")) {
            if (input.equalsIgnoreCase("ave")) {
                this.nome = "ave";
            } else {
                this.nome = "mamifero";
            }
        } else {
            if (input.equalsIgnoreCase("inseto")) {
                this.nome = "inseto";
            } else {
                this.nome = "anelideo";
            }
        }
    }

    public String getNome() {
        return nome;
    }
}

class Classe {
    private String nome;

    public Classe(Scanner sc, Filo filo) {
        String input = sc.next();
        if (filo.getNome().equalsIgnoreCase("ave")) {
            if (input.equalsIgnoreCase("carnivoro")) {
                this.nome = "aguia";
            } else {
                this.nome = "pomba";
            }
        } else if (filo.getNome().equalsIgnoreCase("mamifero")) {
            if (input.equalsIgnoreCase("onivoro")) {
                this.nome = "homem";
            } else {
                this.nome = "vaca";
            }
        } else if (filo.getNome().equalsIgnoreCase("inseto")) {
            if (input.equalsIgnoreCase("hematofago")) {
                this.nome = "pulga";
            } else {
                this.nome = "lagarta";
            }
        } else {
            if (input.equalsIgnoreCase("onivoro")) {
                this.nome = "minhoca";
            } else {
                this.nome = "sanguessuga";
            }
        }
    }

    public String getNome() {
        return nome;
    }
}

class Ordem {
    private String nome;

    public Ordem(Scanner sc, Classe classe) {
        sc.next(); // descarta entrada desnecessária
        this.nome = classe.getNome();
    }

    public String getNome() {
        return nome;
    }
}

class Genero {
    private String nome;

    public Genero(Scanner sc, Ordem ordem) {
        sc.next(); // descarta entrada desnecessária
        this.nome = ordem.getNome();
    }

    public String getNome() {
        return nome;
    }
}
