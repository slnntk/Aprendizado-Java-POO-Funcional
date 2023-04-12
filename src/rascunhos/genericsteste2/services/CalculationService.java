package rascunhos.genericsteste2.services;

import java.util.List;

public class CalculationService {

    public static <T extends Comparable<T>> T max(List<T> listGeneric){
        if (listGeneric.isEmpty()){
            throw new IllegalStateException("List can't be empty");
        }
        T max = listGeneric.get(0);
        for (int i = 1;i < listGeneric.size();i++){
            if (listGeneric.get(i).compareTo(max) > 0){
                max = listGeneric.get(i);
            }
        }
        return max;
    }

}
