package progFuncionaFunction.util;

import progFuncionaFunction.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSumm(List<Product> list, Predicate<Product> criterio) {
            double sum = 0;
            for (Product product : list){
                if (criterio.test(product)){
                    sum+= product.getPrice();
                }
            }
            return sum;
    }
}


