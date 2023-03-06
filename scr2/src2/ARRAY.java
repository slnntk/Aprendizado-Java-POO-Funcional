import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ARRAY {

    public static void main(String[] args) throws IOException {
        List<String> lista = new ArrayList<>();

       lista.add("maria");
       lista.add("Alex");
       lista.add("Bob");
       lista.add("Anna");

       lista.add(2, "Marco");

       for (String nomes : lista){
           System.out.println(nomes);
       }

        System.out.println("-----------------------");

       lista.removeIf(x -> x.toLowerCase().charAt(0) == 'm');

        for (String nomes : lista){
            System.out.println(nomes);
        }

        List<String> result = lista.stream().filter(x -> x.charAt(0) == 'A').toList();
        System.out.println("-----------------------");

        for (String nomes : result){
            System.out.println(nomes);
        }

        System.out.println("-----------------------");

        String name = lista.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
        System.out.println(name);

    }
}

