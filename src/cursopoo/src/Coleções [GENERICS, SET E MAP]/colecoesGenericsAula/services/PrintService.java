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
        System.out.printf("List: ");
        System.out.println(getList());
    }

}
