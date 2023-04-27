package beecrowd.exerciciosResolvidos;
import java.io.*;
import java.util.*;

public class D3038_FILE {
    private static String path = "C:\\Users\\alunok11\\Desktop";
    private static String pathIn = "\\simuladoIn.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        readFile rf = new readFile();
        List<String> cart = rf.readFileMethod(path, pathIn);
        Criptografia criptografia = new Criptografia();
        for (String s : criptografia.desCriptografar(cart)){
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
    public String criptografar(List<String> cartaCriptografada) {
        return null;
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
    String criptografar(List<String> cartaCriptografada);
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

class readFile implements readFileInterFace{

    @Override
    public List<String> readFileMethod(String path, String in) {
        List<String> carta = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path + in))) {
            String line = br.readLine();
            while (line != null) {
                carta.add(line+"\n");
                line = br.readLine();
            }
        } catch (FileException | IOException e) {
            throw new FileException("Error in found");
        }
        return carta;
    }
}

interface readFileInterFace{
    List<String> readFileMethod(String path, String in);
}

class FileException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public FileException(String message) {
        super(message);
    }
}

