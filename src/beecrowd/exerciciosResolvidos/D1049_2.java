package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1049_2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        new Pesquisadora();
    }
}

class Pesquisadora{

    public Pesquisadora() {
        Scanner sc = new Scanner(System.in);
        dadosConhecidos(sc);
    }
    public void dadosConhecidos(Scanner sc){
        String[] vetor = new String[3];
        for (int i = 0; i < 3; i++) {
            vetor[i] = sc.next();
        }
        animalConhecido(vetor);
    }

    public void animalConhecido(String[] vetor){
        Animal animal = AnimalFactory.getAnimal(vetor);
        System.out.println(animal.getNome());
    }
}

abstract class Animal {

    private String nome;
    abstract String getNome();
}

class AnimalFactory {
    public static Animal getAnimal(String[] vetor) {

        if (vetor[0].equalsIgnoreCase("vertebrado")) {
            if (vetor[1].equalsIgnoreCase("ave")) {
                if (vetor[2].equalsIgnoreCase("carnivoro")) {
                    return new Aguia();
                } else {
                    return new Pomba();
                }
            } else {
                if (vetor[2].equalsIgnoreCase("onivoro")) {
                    return new Homem();
                } else {
                    return new Vaca();
                }

            }

        } else {
            if (vetor[1].equalsIgnoreCase("inseto")) {
                if (vetor[2].equalsIgnoreCase("hematofago")) {
                    return new Pulga();
                } else {
                    return new Lagarta();
                }
            } else {
                if (vetor[2].equalsIgnoreCase("onivoro")) {
                    return new Minhoca();
                } else {
                    return new Sanguessuga();
                }

            }

        }

    }
}

class Aguia extends Animal{

    @Override
    String getNome() {
        return "aguia";
    }
}

class Pomba extends Animal{

    @Override
    String getNome() {
        return "pomba";
    }
}
class Homem extends Animal{

    @Override
    String getNome() {
        return "homem";
    }
}

class Vaca extends Animal{

    @Override
    String getNome() {
        return "vaca";
    }
}
class Pulga extends Animal{

    @Override
    String getNome() {
        return "pulga";
    }
}
class Lagarta extends Animal{

    @Override
    String getNome() {
        return "lagarta";
    }
}

class Minhoca extends Animal{

    @Override
    String getNome() {
        return "minhoca";
    }
}

class Sanguessuga extends Animal{

    @Override
    String getNome() {
        return "sanguessuga";
    }
}

