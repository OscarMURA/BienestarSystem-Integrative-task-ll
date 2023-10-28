package exceptions;

/**
 * The `ExceptionFormatFileNotAllowed` class is a custom exception that is thrown when a file with a
 * specific style is not allowed.
 */
public class ExceptionFormatFileNotAllowed extends Exception{

    // The code is defining a custom exception class called `ExceptionFormatFileNotAllowed`.
    public ExceptionFormatFileNotAllowed(String message){
        super("The style of the "+message+"file is not allowed");
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
