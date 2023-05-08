package rascunhos.teste2.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class File {

    private Set<String> fileReader(){

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Users\\cassi\\Downloads\\DemoCotacoesHistoricas12022003.zip"))){
            String line = br.readLine();
            while (line != null){
                line = br.readLine();

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
