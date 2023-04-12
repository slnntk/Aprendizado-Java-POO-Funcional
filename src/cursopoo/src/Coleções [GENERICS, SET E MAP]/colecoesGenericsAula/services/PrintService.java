package colecoesGenericsAula.services;

import java.util.List;

public interface PrintService {

    List<Integer> getList();


    default void addValue(int value){
        getList().add(value);
    }

    default Integer first(){
        if (getList().isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return getList().get(0);
    }

    default void print(){
        System.out.print("[");
        if (!getList().isEmpty()){
            System.out.print(getList().get(0));
        }
        for (int i = 1;i < getList().size();i++){
            System.out.printf(", " + getList().get(i));
        }
        System.out.print("]");
    }
}
