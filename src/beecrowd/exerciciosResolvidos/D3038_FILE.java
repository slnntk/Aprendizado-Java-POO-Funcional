package beecrowd.exerciciosResolvidos;

import java.io.*;
import java.util.*;

class AOAO {
    private static String path = "C:\\Users\\alunok11\\Desktop";
    private static String pathIn = "\\simuladoIn.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        readTxt rf = new readTxt();
        List<String> cart = rf.readMethod(sc);
        Criptografia criptografia = new Criptografia();
        for (String s : criptografia.criptografar(cart)){
            System.out.print(s);
        }

    }
}

class Criptografia implements CriptografiaInterface{

    Map<String, String> predefinido = new HashMap<>();

    public Criptografia() {
        predefinido.put("@", "a");
        predefinido.put("&", "e");
        predefinido.put("!", "i");
        predefinido.put("*", "o");
        predefinido.put("#", "u");
    }

    @Override
    public List<String> criptografar(List<String> cartaCriptografada) {
        List<String> list = new ArrayList<>();

        for (String s : cartaCriptografada){
            for (int i = 0;i < s.length();i++){;
                if (predefinido.containsKey(String.valueOf(s.charAt(i))) ){
                    list.add(predefinido.get(String.valueOf(s.charAt(i))));
                }else{
                    list.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        return list;
    }

    @Override
    public List<String> desCriptografar(List<String> cartaCriptografada) {

        List<String> list = new ArrayList<>();

        for (String s : cartaCriptografada){
            for (int i = 0;i < s.length();i++){
                String chr = predefinido.get(String.valueOf(s.charAt(i)));
                if (chr!=null){
                    list.add(chr);
                }else{
                    list.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        return list;
    }
}

interface CriptografiaInterface{
    List<String> criptografar(List<String> cartaCriptografada);
    List<String> desCriptografar(List<String> cartaCriptografada);
}

class Carta{

    private String text;

    public Carta(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getText() {
        return text;
    }
}

class readTxt implements readFileInterFace{

    @Override
    public List<String> readMethod(Scanner sc) {
        List<String> carta = new ArrayList<>();
        String texto;
        do {
            try {
                texto = sc.nextLine();
                carta.add(texto + "\n");
            } catch (NoSuchElementException e) {
                texto = "";
            }
        } while (!texto.isEmpty());
        return carta;
    }
}

interface readFileInterFace{
    List<String> readMethod(Scanner sc);
}

class FileException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public FileException(String message) {
        super(message);
    }
}

