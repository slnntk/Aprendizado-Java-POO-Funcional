package rascunhos.Func.application;

import rascunhos.Func.entities.Product;
import rascunhos.Func.util.ProductService;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Set<Product> productSet = new HashSet<>();
        ProductService ps = new ProductService();

        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\TESTEPRODUCTIN.txt";
        String out = "\\TESTEPRODUCTOUT.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String line = br.readLine();
            while (line != null){
                String[] parameter = line.split(",");
                productSet.add(new Product(parameter[0], Double.parseDouble(parameter[1])));
                line = br.readLine();
            }
        } catch (FileException | IOException e) {
            throw new FileException("Error in read the file");
        }
        Set<Product> productList = productSet.stream().filter(product -> product.getName().charAt(0) == 'T').collect(Collectors.toSet());
        System.out.println(productList);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){
            double sumResult = ps.filteredSum(productSet, p -> p.getPrice() > 0);
            bw.write(String.valueOf(sumResult));
        } catch (FileException | IOException e) {
            throw new FileException("Error in write file");
        }
    }
}
