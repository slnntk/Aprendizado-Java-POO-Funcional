package colecoesSetAula.application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Set<String> stringSet = new LinkedHashSet<>();

        stringSet.add("TV");
        stringSet.add("Tablet");
        stringSet.add("Notebook");

        System.out.println(stringSet.contains("Notebook"));

        for (String string : stringSet){
            System.out.println(string);
        }

    }
}
