package arquivosExercicioProposto;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enther the path of the archive: ");
        String strPath = sc.nextLine();
        File path = new File(strPath);

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            File fileOut = new File(path.getParent() + "\\out");
            FileWriter fileSumarry = new FileWriter(fileOut + "\\summary1.txt");
            BufferedWriter bw = new BufferedWriter(fileSumarry);

            String line = br.readLine();
            while (line != null){
                String[] parametros = line.split(",");
                Product product = new Product(parametros[0], Double.parseDouble(parametros[1]), Integer.parseInt(parametros[2]));

                bw.write(product.getNome() + ",");
                bw.write(Double.toString(product.getPrice()));
                bw.newLine();
                line = br.readLine();
             }
            bw.close();
            System.out.println("Summary file created successfully!");
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }


    }
}

