package colecoesSetAula.application;

import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        Set<String> stringSet = new TreeSet<>();

        stringSet.add("TV");
        stringSet.add("Tablet");
        stringSet.add("Notebook");

        System.out.println(stringSet.contains("Notebook"));

        for (String string : stringSet){
            System.out.println(string);
        }

    }
}
