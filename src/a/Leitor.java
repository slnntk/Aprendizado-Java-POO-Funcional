package a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    public List<Services> lerArchiveEmp(String path) {
        List<Services> servicesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] parametros = line.split("\t");
                if (!line.isEmpty()){
                    if (Character.isDigit(line.charAt(0)) && parametros.length > 4){
                        String valorUnitario = parametros[6].replace("R$", "").trim().replace(".", "").replace(",", ".");
                        String valorUnitarioBDI = parametros[7].replace("R$", "").trim().replace(".", "").replace(",", ".");
                        parametros[6] = valorUnitario;
                        parametros[7] = valorUnitarioBDI;
                        Services a = new Services(parametros);
                        servicesList.add(a);
                        line = br.readLine();
                    }
                    else{
                        line = br.readLine();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return servicesList;
    }

    public List<Services> lerArchiveMlg(String path) {
        List<Services> servicesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] parametros = line.split("\t");
                if (!line.isEmpty()){
                    if(Character.isDigit(line.charAt(0)) && parametros.length > 4){
                        String valorUnitario = parametros[4].replace("R$", "").trim().replace(".", "").replace(",", ".");
                        String valorUnitarioBDI = parametros[5].replace("R$", "").trim().replace(".", "").replace(",", ".");
                        String valorT = parametros[6].replace("R$", "").trim().replace(".", "").replace(",", ".");
                        String valorTBDI = parametros[7].replace("R$", "").trim().replace(".", "").replace(",", ".");
                        parametros[4] = valorUnitario;
                        parametros[5] = valorUnitarioBDI;
                        parametros[6] = valorT;
                        parametros[7] = valorTBDI;
                        Services a = new Services(parametros, 1);
                        servicesList.add(a);
                        line = br.readLine();
                    }
                    else{
                        line = br.readLine();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return servicesList;
    }
}




