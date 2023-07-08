package a;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Leitor a = new Leitor();
        List<Item> listEmp = a.lerArchiveEmp("D:\\Users\\cassi\\Downloads-1\\tsv\\EMP2.tsv");
        List<Item> listMLG = a.lerArchiveMlg("D:\\Users\\cassi\\Downloads-1\\tsv\\MLG2.tsv");
        compararListas(listEmp, listMLG);
    }

    public static void compararListas(List<Item> emp, List<Item> mlg) {
        for (Item itemEmpresa : emp) {
            for (Item itemMLG : mlg) {
                if (itemEmpresa.getItem().equals(itemMLG.getItem())) {
                    if (itemMLG.getValorUnitario() > itemEmpresa.getValorUnitario()){
                        System.out.println("MLG: " + itemMLG.getItem()+ ": " + itemMLG.getValorUnitario());
                        System.out.println("IFCE: " + itemEmpresa.getItem() + ": " + itemEmpresa.getValorUnitario());
                        System.out.println("--------------------------------------------------------------------");
                    }
                }
            }
        }
    }
}
