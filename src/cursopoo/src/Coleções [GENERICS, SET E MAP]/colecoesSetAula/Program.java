package colecoesSetAula;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        //union -> elemento1.addAll(elemento2)
        // (elementos que tem em um mas não tem no outro)

        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println("Uniao A e B: " + c); //Imprimir a união de a e b

        //intersession -> elemento1.retainAll(elemento2)
        // (elementos em comum entre o elemento1 e o elemento2)

        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println("Intersseção A e B " + d);

        //difference -> elemento1.removeAll(elemento2)
        // (remover todo mundo do conjunto elemento1 que estiver no conjunto b)
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println("Diferença A e B: " + e);


    }
}
