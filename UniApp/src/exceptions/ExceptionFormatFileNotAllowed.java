package exceptions;

public class ExceptionFormatFileNotAllowed extends Exception{

    public ExceptionFormatFileNotAllowed(String message){
        super("The style of the "+message+"file is not allowed");
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
