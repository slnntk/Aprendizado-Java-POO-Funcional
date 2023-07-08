package a;

import a.entities.Item;
import a.interfaces.VerificadorInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Verificador implements VerificadorInterface {

    public void compararListas(List<Item> emp, List<Item> mlg) {
        Set<String> mlgItems = new HashSet<>();
        for (Item itemMLG : mlg) {
            mlgItems.add(itemMLG.getItem());
        }

        for (Item itemEmpresa : emp) {
            if (mlgItems.contains(itemEmpresa.getItem())) {
                for (Item itemMLG : mlg) {
                    if (itemEmpresa.getItem().equals(itemMLG.getItem()) && itemMLG.getValorUnitario() > itemEmpresa.getValorUnitario()) {
                        System.out.println("MLG: " + itemMLG.getItem()+ ": " + itemMLG.getValorUnitario());
                        System.out.println("IFCE: " + itemEmpresa.getItem() + ": " + itemEmpresa.getValorUnitario());
                        System.out.println("--------------------------------------------------------------------");
                    }
                }
            }
        }
    }

}
