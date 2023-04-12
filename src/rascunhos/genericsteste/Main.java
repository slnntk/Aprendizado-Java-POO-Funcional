package rascunhos.genericsteste;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GenericPrintService<Integer> integerGenericPrintService = new GenericPrintService<>();
        integerGenericPrintService.getList().add(1);
        integerGenericPrintService.getList().add(111);
        integerGenericPrintService.getList().add(22);
        integerGenericPrintService.getList().add(39);
        integerGenericPrintService.getList().add(4);

        integerGenericPrintService.printList();
    }
}

class GenericPrintService<GenericType>{

    private final List<GenericType> genericTypeList = new ArrayList<>();

    public List<GenericType> getList() {
        return genericTypeList;
    }

    public void printList(){
        System.out.print("[");
        for (GenericType genericType : getList()){
            if (genericType == getList().get(0)){
                System.out.print(genericType);
            }
            else{
                System.out.printf(", " + genericType);
            }
        }
        System.out.print("]");
    }


}
