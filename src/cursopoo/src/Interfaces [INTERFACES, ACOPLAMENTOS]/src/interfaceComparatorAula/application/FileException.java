package src.interfaceComparatorAula.application;

import java.io.Serial;
class FileException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public FileException(String msg){
        super(msg);
    }

}