package a;

import a.entities.Item;
import a.interfaces.LeitorInterface;
import a.services.Leitor;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        LeitorInterface leitor = new Leitor();
        List<Item> listEmp = leitor.lerArchiveEmp("D:\\Users\\cassi\\Downloads-1\\tsv\\EMP4.tsv");
        List<Item> listMLG = leitor.lerArchiveMlg("D:\\Users\\cassi\\Downloads-1\\tsv\\MLG4.tsv");
        Verificador verificador = new Verificador();
        verificador.compararListas(listEmp, listMLG);
    }


}
