package progFuncionaFunction.application;

import progFuncionaFunction.entities.Product;
import progFuncionaFunction.util.ProductService;

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
        System.out.println(ps.filteredSum(list, product -> product.getPrice() > 0));

    }
}
