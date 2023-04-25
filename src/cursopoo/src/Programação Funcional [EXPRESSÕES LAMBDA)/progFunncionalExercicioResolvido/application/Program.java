package progFunncionalExercicioResolvido.application;

import progFunncionalExercicioResolvido.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Program {

    static String path = "C:\\Users\\SLNNTK\\Documents\\T";
    static String in = "\\TESTEPRODUCTIN.txt";
    static String out = "\\out.txt";
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String line = br.readLine();
            while (line != null){
                String[] parameters = line.split(",");
                list.add(new Product(parameters[0], Double.parseDouble(parameters[1])));
                line = br.readLine();
            }
        } catch (FileException | IOException e){
            throw new FileException("Read the file fail");
        }

        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        double avg = list.stream()
                .map(x -> x.getPrice()/ list.size())
                .reduce(0.0, (p1, p2) -> p1+p2).doubleValue();

        List<String> nammesList = list.stream()
                .filter(p -> p.getPrice() < avg)
                .map(p -> p.getName())
                .sorted(comp.reversed()).toList();


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){
            bw.write("Avarage price: "+ String.format("%.2f", avg));
            bw.newLine();
            for (String s : nammesList){
                bw.write(s);
                bw.newLine();
            }
        } catch (FileException | IOException e){
            throw new FileException("Write the file fail");
        }
    }
}
