package a;

import a.entities.Item;
import a.interfaces.LeitorInterface;
import a.services.Leitor;
import a.util.Verificador;

import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        LeitorInterface leitor = new Leitor();
        Set<Item> listEmp = leitor.lerArchiveEmp("D:\\Users\\cassi\\Downloads-1\\tsv\\EMP4.tsv");
        Set<Item> listMLG = leitor.lerArchiveMlg("D:\\Users\\cassi\\Downloads-1\\tsv\\MLG4.tsv");
        Verificador verificador = new Verificador();
        verificador.compararListas(listEmp, listMLG);
    }
}
