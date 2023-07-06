package a;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Leitor a = new Leitor();
        List<Services> listEmp = a.lerArchiveEmp("D:\\Users\\cassi\\Downloads-1\\tsv\\EMP2.tsv");
        List<Services> listMLG = a.lerArchiveMlg("D:\\Users\\cassi\\Downloads-1\\tsv\\MLG2.tsv");


        try{
            for (int i = 0;i < listEmp.size();i++){
                if (listMLG.get(i).getValorUnitario() > listEmp.get(i).getValorUnitario()){
                    System.out.println("MLG: " + listMLG.get(i).getItem() + ": " + listMLG.get(i).getValorUnitario());
                    System.out.println("IFCE: " + listEmp.get(i).getItem() + ": " + listEmp.get(i).getValorUnitario());
                    System.out.println("--------------------------------------------------------------------");
                }
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("Possui uma linha faltando na tabela ! ");;
        }

    }
}
