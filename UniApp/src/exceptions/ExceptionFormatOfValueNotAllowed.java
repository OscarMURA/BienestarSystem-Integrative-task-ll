package exceptions;
import org.junit.Test;
import static org.junit.Assert.*;
public class ExceptionFormatOfValueNotAllowed extends Exception{
    public ExceptionFormatOfValueNotAllowed(String type, String value){
        super("The value/s "+value+" is not allowed for the type "+type);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
