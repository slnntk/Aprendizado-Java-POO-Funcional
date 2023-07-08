package a;

import a.entities.Item;

import java.util.Comparator;

public class ValorUnitarioComparator implements Comparator<Item> {
    @Override
    public int compare(Item s1, Item s2) {
        return s1.getValorUnitario().compareTo(s2.getValorUnitario());
    }
}
