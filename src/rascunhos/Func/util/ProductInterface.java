package rascunhos.Func.util;

import rascunhos.Func.entities.Product;

import java.util.Set;
import java.util.function.Predicate;

public interface ProductInterface {

    double filteredSum(Set<Product> productList, Predicate<Product> productPredicate);

}
