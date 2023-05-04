package rascunhos;

import java.io.Serial;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FabricaDeCifra fb = new FabricaDeCifra();
        fb.readCifra(sc);
        fb.printCifra();
    }
}

class FabricaDeCifra{

    List<String> list = new ArrayList<>();
    CriptografiaInterface ci = new Criptografia();

    public FabricaDeCifra() {

    }

    public void readCifra(Scanner sc){
        try{
            int n = sc.nextInt();
            sc.nextLine();
            String line;
            for (int i = 0;i < n;i++){
                line = sc.nextLine();
                ci.setFatorDeCriptografia(sc.nextInt());
                sc.nextLine();
                list.add(ci.desCriptografar(line));
            }
        } catch (InputMismatchException e){
            throw new ExceptionPersonalizada("Erro na digitação dos valores." + e.getMessage());
        }
    }

    public void printCifra(){
        list.forEach(System.out::println);
    }

}


class Criptografia implements CriptografiaInterface{

    private int fatorDeCriptografia;

    public Criptografia() {

    }

    public int getFatorDeCriptografia() {
        return fatorDeCriptografia;
    }

    public void setFatorDeCriptografia(int fatorDeCriptografia) {
        this.fatorDeCriptografia = fatorDeCriptografia;
    }

    @Override
    public String criptografar(String line) {
        return null;
    }

    @Override
    public String desCriptografar(String line) {

        String output = "";
        int temp;
        char temporaria;
        int valor = getFatorDeCriptografia();
        for (int j = line.length() - 1; j >= 0; j--) {
            temp = ((((int) line.charAt(j) - 'A' - valor + 26) % 26) + 65);
            temporaria = (char) temp;
            output = temporaria + output;
        }
        return output;
    }
}

interface CriptografiaInterface{
    String criptografar(String line);
    String desCriptografar(String line);
    int getFatorDeCriptografia();
    void setFatorDeCriptografia(int fatorDeCriptografia);
}

class ExceptionPersonalizada extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ExceptionPersonalizada(String message) {
        super(message);
    }
}
