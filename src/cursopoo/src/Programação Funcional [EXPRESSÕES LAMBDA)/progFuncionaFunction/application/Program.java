package progFuncionaFunction.application;

import progFuncionaFunction.util.ProductService;
import progFuncionaFunction.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));


        ProductService ps = new ProductService();
        double sum = ps.filteredSumm(list, p -> p.getName().toUpperCase().charAt(0) == 'T');
        System.out.println(sum);

    }
}
