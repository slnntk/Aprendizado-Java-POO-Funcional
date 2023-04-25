package rascunhos.Func.application;

import rascunhos.Func.entities.Product;

import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Program {
    public static void main(String[] args) {

        Set<Product> productSet = new HashSet<>();

        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\TESTEPRODUCTIN.txt";
        String out = "\\TESTEPRODUCTOUT2.txt";

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

        Comparator<String> comparator = (x1, x2) -> x1.toUpperCase().compareTo(x2.toUpperCase());


        double avg = productSet.stream()
                    .map(x -> x.getPrice())
                    .reduce(0.0, (x, y) -> x+y/productSet.size());

        List<String> stringSet = productSet.stream()
                    .filter(x -> x.getPrice() < avg)
                    .map(x -> x.getName())
                    .sorted(comparator.reversed()).toList();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){
            bw.write("Media: " + String.format("%.2f", avg));
            bw.newLine();
            for (String s : stringSet){
                bw.write(s);
                bw.newLine();
            }
        } catch (FileException | IOException e) {
            throw new FileException("Error in write file");
        }
    }
}
