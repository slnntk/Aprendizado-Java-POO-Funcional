package progFuncionalCostumerAula.application;

import progFuncionalCostumerAula.entities.Product;
import progFuncionalCostumerAula.util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        Consumer<Product> productConsumer = p -> p.setPrice(p.getPrice()*factor);;
       list.forEach(Product::staticPriceUpdate);

       double factor = 1.1;

       list.forEach(System.out::println);
    }

}
