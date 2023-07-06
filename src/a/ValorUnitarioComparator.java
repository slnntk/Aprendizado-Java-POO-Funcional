package a;

import java.util.Comparator;

public class ValorUnitarioComparator implements Comparator<Services> {
    @Override
    public int compare(Services s1, Services s2) {
        return s1.getValorUnitario().compareTo(s2.getValorUnitario());
    }
}
