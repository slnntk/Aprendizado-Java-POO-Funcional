package arquivosWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};

        String path = "D:\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (String line : lines){
                bw.write(line); //escreve a linha
                bw.newLine(); //quebra de linha
            }

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }


    }
}
