package colecoesSetExercicioAula.application;

import colecoesSetExercicioAula.entities.Product;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\TESTEINPUT.txt";
        String out = "\\TESTEOUT.txt";

        Set<Product> set = readFile(path, in);
        writeFile(path, out, set);

        Product product = new Product("Notebook", 1200.0);
        System.out.println(set.contains(product));

    }

    public static Set<Product> readFile(String path, String in){

        Set<Product> set = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String line = br.readLine();
            while (line != null){
                String[] parameters = line.split(",");
                set.add(new Product(parameters[0], Double.parseDouble(parameters[1])));
                line = br.readLine();
            }

        } catch (IOException | FileException e){
            throw new FileException("Error in read the archive");
        }
    return set;
    }

    public static void writeFile(String path, String out, Set<Product> productSet){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){

            for (Product product : productSet){
                bw.write(product.toString());
                bw.newLine();
            }
        } catch (IOException | FileException e){
            throw new FileException("Error in write the archive");
        }

    }

}
