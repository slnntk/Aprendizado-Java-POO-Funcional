package colceosGenericsDelimitadoAula.services;

import java.io.Serial;
public class FileException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public FileException(String msg){
        super(msg);
    }

}