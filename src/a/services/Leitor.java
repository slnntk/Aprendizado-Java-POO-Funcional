package a.services;

import a.interfaces.LeitorInterface;
import a.entities.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class Leitor implements LeitorInterface {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public Set<Item> lerArchiveEmp(String path) {
        Set<Item> itemList = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parametros = line.split("\t");

                if (!line.isEmpty() && Character.isDigit(line.charAt(0)) && parametros.length > 4) {
                    String valorUnitario = formatarValor(parametros[6]);
                    String valorUnitarioBDI = formatarValor(parametros[7]);
                    parametros[6] = valorUnitario;
                    parametros[7] = valorUnitarioBDI;
                    Item a = new Item(parametros);
                    itemList.add(a);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return itemList;
    }

    public Set<Item> lerArchiveMlg(String path) {
        Set<Item> itemList = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parametros = line.split("\t");

                if (!line.isEmpty() && Character.isDigit(line.charAt(0)) && parametros.length > 4) {
                    String valorUnitario = formatarValor(parametros[4]);
                    String valorUnitarioBDI = formatarValor(parametros[5]);
                    String valorT = formatarValor(parametros[6]);
                    String valorTBDI = formatarValor(parametros[7]);
                    parametros[4] = valorUnitario;
                    parametros[5] = valorUnitarioBDI;
                    parametros[6] = valorT;
                    parametros[7] = valorTBDI;
                    Item a = new Item(parametros, 1);
                    itemList.add(a);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return itemList;
    }

    private String formatarValor(String valor) {
        valor = valor.replace("R$", "").replaceAll("[.,]", "");
        double valorFormatado = Double.parseDouble(valor) / 100.0;
        return DECIMAL_FORMAT.format(valorFormatado);
    }
}
