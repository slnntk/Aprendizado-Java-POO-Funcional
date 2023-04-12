package colecoesGenericsAula.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<GenericType>{

    List<GenericType> genericList = new ArrayList<>();

    public void addValue(GenericType value){
        getList().add(value);
    }

    public GenericType first(){
        if (getList().isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return getList().get(0);
    }

    public void print(){
        System.out.print("[");
        if (!getList().isEmpty()){
            System.out.print(getList().get(0));
        }
        for (int i = 1;i < getList().size();i++){
            System.out.printf(", " + getList().get(i));
        }
        System.out.print("]");
    }

    public List<GenericType> getList() {
        return genericList;
    }
}
