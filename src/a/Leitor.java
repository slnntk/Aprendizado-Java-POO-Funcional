package a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    public List<Servicos> lerArchiveEmp(String path) {
        List<Servicos> servicosList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] parametros = line.split("\t");
                // Remover "R$", espaço em branco, pontos e substituir vírgulas por pontos
                String valorUnitario = parametros[6].replace("R$", "").trim().replace(".", "").replace(",", ".");
                String valorUnitarioBDI = parametros[7].replace("R$", "").trim().replace(".", "").replace(",", ".");
                parametros[6] = valorUnitario;
                parametros[7] = valorUnitarioBDI;
                Servicos a = new Servicos(parametros);
                servicosList.add(a);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return servicosList;
    }

    public List<Servicos> lerArchiveMlg(String path) {
        List<Servicos> servicosList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] parametros = line.split("\t");
                // Remover "R$", espaço em branco, pontos e substituir vírgulas por pontos
                String valorUnitario = parametros[4].replace("R$", "").trim().replace(".", "").replace(",", ".");
                String valorUnitarioBDI = parametros[5].replace("R$", "").trim().replace(".", "").replace(",", ".");
                String valorT = parametros[6].replace("R$", "").trim().replace(".", "").replace(",", ".");
                String valorTBDI = parametros[7].replace("R$", "").trim().replace(".", "").replace(",", ".");
                parametros[4] = valorUnitario;
                parametros[5] = valorUnitarioBDI;
                parametros[6] = valorT;
                parametros[7] = valorTBDI;
                Servicos a = new Servicos(parametros, 1);
                servicosList.add(a);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return servicosList;
    }
}




