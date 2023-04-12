package colecoesGenericsTiposCuringaAula.application;

import java.util.Arrays;
import java.util.List;

//supertipo de qualquer tipo de lista

public class Program {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(5, 2, 10);
        printList(integerList);
    }

    public static void printList(List<?> list){
        for (Object object : list){
            System.out.println(object);
        }

    }

}
