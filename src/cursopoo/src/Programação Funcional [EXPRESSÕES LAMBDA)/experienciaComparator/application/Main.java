package experienciaComparator.application;


import experienciaComparator.entities.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        Comparator<Product> productComparator = new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return product.getName().toUpperCase().compareTo(t1.getName().toUpperCase());
            }
        };
        list.sort(productComparator);
    }
}
