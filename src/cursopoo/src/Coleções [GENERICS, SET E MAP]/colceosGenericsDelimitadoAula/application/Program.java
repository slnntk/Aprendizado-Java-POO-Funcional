package colceosGenericsDelimitadoAula.application;

import colceosGenericsDelimitadoAula.entities.Product;
import colceosGenericsDelimitadoAula.services.CalculationService;
import colceosGenericsDelimitadoAula.services.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\Administrator\\Downloads\\teste";
        String inCsvArchive = "\\testetexto.txt";
        String outCsvArchive = "\\produtos.txt";


        List<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path + inCsvArchive))){
            String line = br.readLine();
            while (line != null){
                String[] generics = line.split(",");
                productList.add(new Product(generics[0], Double.parseDouble(generics[1])));
                line = br.readLine();
            }
        } catch (IOException | FileException e){
            throw new FileException("Error in read the archive.");
        }

        Product x = CalculationService.max(productList);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + outCsvArchive))){
            for (Product products : productList){
                System.out.println(products.toString());
                bw.write(products.toString());
                bw.newLine();
            }
            bw.write("Most expensive:\n" + x.toString());
            System.out.println();
            System.out.println("Success write file");
        } catch (IOException | FileException e){
            throw new FileException("Error in read the archive.");
        }

    }
}
