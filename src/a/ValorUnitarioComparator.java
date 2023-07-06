package a;

import java.util.Comparator;

public class ValorUnitarioComparator implements Comparator<Servicos> {
    @Override
    public int compare(Servicos s1, Servicos s2) {
        return s1.getValorUnitario().compareTo(s2.getValorUnitario());
    }
}
