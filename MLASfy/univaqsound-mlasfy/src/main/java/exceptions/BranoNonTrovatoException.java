package exceptions;

public class BranoNonTrovatoException extends Exception{
public BranoNonTrovatoException(String message, Throwable cause) {
    super(message, cause);
}
public BranoNonTrovatoException(String message){
    super(message);
}

}
