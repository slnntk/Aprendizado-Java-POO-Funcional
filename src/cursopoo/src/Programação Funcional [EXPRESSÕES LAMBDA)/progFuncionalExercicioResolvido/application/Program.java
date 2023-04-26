package progFuncionalExercicioResolvido.application;

import progFuncionalExercicioResolvido.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> conjProducts = new ArrayList<>();

        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\TESTEPRODUCTIN.txt";
        String out = "\\TESTEPRODUCTout2.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String line = br.readLine();
            while (line != null){
                String[] parameter = line.split(",");
                conjProducts.add(new Product(parameter[0], Double.parseDouble(parameter[1])));
                line = br.readLine();
            }
        } catch (IOException | FileException e){
            throw new FileException("Error in read the file");
        }

        double avg = conjProducts.stream()
                .map(x -> x.getPrice()/conjProducts.size())
                .reduce(0.0, (p1,p2) -> p1 + p2).doubleValue();

        Comparator<String> comparator = (x,y) -> x.toUpperCase().compareTo(y.toUpperCase());

        List<String> nameProducts = conjProducts.stream()
                .filter(x -> x.getPrice() < avg)
                .map(x -> x.getName())
                .sorted(comparator.reversed()).toList();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){
            bw.write("Average price: " + String.format("%.2f", avg)+"\n");
            Consumer<String> consumer = x -> {
                try {
                    bw.write(x);
                    bw.newLine();
                } catch (IOException e) {
                    throw new FileException("Error in write the productsname");
                }
            };
            nameProducts.forEach(consumer);
        } catch (IOException | FileException e){
            throw new FileException("Error in write the file");
        }


    }

}
