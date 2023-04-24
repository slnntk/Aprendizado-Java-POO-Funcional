package experienciaComparator.application;

import experienciaComparator.entities.Product;

import java.util.Comparator;

public class MyComparator implements Comparator<Product>{
    @Override
    public int compare(Product product, Product t1) {
        return product.getName().toUpperCase().compareTo(t1.getName().toUpperCase());
    }
}
