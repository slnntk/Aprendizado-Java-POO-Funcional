package progFuncionaFunction.util;

import progFuncionaFunction.entities.Product;

import java.util.List;

public class ProductService {

    public double filteredSumm(List<Product> product){
        double sum = 0.0;
        for (Product l : product){
            if (l.getName().toUpperCase().charAt(0) == 'T'){
                    sum += l.getPrice();
            }
        }
        return sum;
    }
}
