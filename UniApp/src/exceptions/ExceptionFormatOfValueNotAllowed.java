package exceptions;
/**
 * The code defines a custom exception class called ExceptionFormatOfValueNotAllowed that is used to
 * handle cases where a value is not allowed for a specific type.
 */
public class ExceptionFormatOfValueNotAllowed extends Exception{
   // The code is defining a custom exception class called `ExceptionFormatOfValueNotAllowed`.
    public ExceptionFormatOfValueNotAllowed(String type, String value){
        super("The value/s "+value+" is not allowed for the type "+type);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
