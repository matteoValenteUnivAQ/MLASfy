package exceptions;

public class BranoNotPlayException extends Exception {
    public BranoNotPlayException(String message, Throwable cause) {
        super(message, cause);
    }
    public BranoNotPlayException(String message){
        super(message);
    }
    
}
