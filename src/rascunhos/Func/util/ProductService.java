package rascunhos.Func.util;

import rascunhos.Func.entities.Product;

import java.util.Set;
import java.util.function.Predicate;

public class ProductService implements ProductInterface{
    @Override
    public double filteredSum(Set<Product> productList, Predicate<Product> productPredicate) {

        double sum = 0.0;
        for (Product product : productList){
            if (productPredicate.test(product)){
                sum += product.getPrice();
            }
        }
        return sum;
    }
}
