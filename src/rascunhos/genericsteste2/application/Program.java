package rascunhos.genericsteste2.application;

import rascunhos.genericsteste2.entities.Product;
import rascunhos.genericsteste2.services.CalculationService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\Administrator\\Downloads\\teste";
        String in = "\\testetexto.txt";
        String out = "\\rascunho.txt";

        List<Product> productList = readFile(path, in);
        writeFile(productList, path, out);


    }






    public static List<Product> readFile(String path, String in){
        List<Product> productList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){

            String line = br.readLine();
            while (line != null){
                String[] parametros = line.split(",");
                productList.add(new Product(parametros[0], Double.parseDouble(parametros[1])));
                line = br.readLine();
            }
        } catch (IOException | FileException e){
            System.out.println("Error in the read");
        }
        return productList;
    }

    public static void writeFile(List<Product> productList, String path, String out){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){

            for (Product product : productList){
                bw.write(product.toString());
                bw.newLine();
            }
            Product maxService = CalculationService.max(productList);
            bw.write("Most expensive:\n" + maxService.toString());
        } catch (IOException | FileException e){
            System.out.println("Error in the write");
        }

    }

}
