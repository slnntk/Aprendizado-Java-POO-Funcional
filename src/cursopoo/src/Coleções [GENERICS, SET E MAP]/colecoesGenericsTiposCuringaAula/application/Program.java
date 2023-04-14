package colecoesGenericsTiposCuringaAula.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//supertipo de qualquer tipo de lista

public class Program {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(200);
        printList(integerList);

    }

    public static void printList(List<?> list){

        for (Object object : list){
            System.out.println(object);
        }

    }

}
