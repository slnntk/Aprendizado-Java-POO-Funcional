package colecoesGenericsAula.services;

import java.util.ArrayList;
import java.util.List;

public class ConcretPrintService implements PrintService{

    private final List<Integer> integerList = new ArrayList<>();

    @Override
    public List<Integer> getList() {
        return integerList;
    }
}
