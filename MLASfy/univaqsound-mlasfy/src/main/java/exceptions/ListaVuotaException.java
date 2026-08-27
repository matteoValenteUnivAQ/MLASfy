package exceptions;

public class ListaVuotaException extends Exception {
    public ListaVuotaException(String message, Throwable cause) {
        super(message, cause);
    }
    public ListaVuotaException(String message){
        super(message);
    }
    
}
