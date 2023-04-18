package progFuncionalCostumerAula.application;

import progFuncionalCostumerAula.entities.Product;
import progFuncionalCostumerAula.util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        /** Forma convencional
            for (Product product : list){
                new PriceUpdate().accept(product);
        }**/

/*Forma nova->*/list.forEach(new PriceUpdate());

        /** Forma convencional
            for (Product product : list){
                System.out.println(product);
        }**/

/*Forma nova->*/list.forEach(System.out::println);

        list.forEach(new PriceUpdate());
    }

}
