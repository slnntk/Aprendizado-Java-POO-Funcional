package colecoesSetAula.application;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Set<String> stringSet = new HashSet<>();

        stringSet.add("TV");
        stringSet.add("Tablet");
        stringSet.add("Notebook");

        System.out.println(stringSet.contains("Notebook"));

        for (String string : stringSet){
            System.out.println(string);
        }

    }
}
