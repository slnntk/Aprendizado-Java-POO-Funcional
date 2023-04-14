package colecoesGenericsTiposCuringaAula.application;

import java.util.Arrays;
import java.util.List;


public class Program {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(5, 2, 10);
        List<String> stringList = Arrays.asList("Maria", "Alex", "Bob");
        printList(integerList);
        printList(stringList);

    }

    public static void printList(List<?> list){

        for (Object object : list){
            System.out.println(object);
        }

    }

}
