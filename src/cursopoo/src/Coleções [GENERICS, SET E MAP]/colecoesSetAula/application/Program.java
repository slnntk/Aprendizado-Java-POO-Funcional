package colecoesSetAula.application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();

        set.add("Tv");
        set.add("Tablet");
        set.add("Notebook");

        /* Predicado: x tal que x alguma coisa */
        set.removeIf(x -> x.charAt(0) == 'T');
        for (String string : set){
            System.out.println(string);
        }

    }
}
