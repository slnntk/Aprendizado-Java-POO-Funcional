package progFuncionalExperienciaComparator.application;

import progFuncionalExperienciaComparator.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));


        Collections.sort(list);
        list.forEach(System.out::println);
    }

   
}
