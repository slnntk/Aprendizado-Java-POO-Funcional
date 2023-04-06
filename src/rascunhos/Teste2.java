package rascunhos;

import java.io.*;
import java.util.Scanner;

public class Teste2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strPath = "D:\\testes\\TESTEINPUT.txt";
        File path = new File(strPath);


        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            File file = new File(path.getParent() + "\\out");
            FileWriter fileWriter = new FileWriter(file + "summary3.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            while (line != null){
                String[] parameters = line.split(",");
                Product product = new Product(parameters[0], Double.parseDouble(parameters[1]), Integer.parseInt(parameters[2]));
                bw.write(product.getName() + ",");
                bw.write(String.valueOf(product.getPrice()));
                bw.newLine();
                line = br.readLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Product{

    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}