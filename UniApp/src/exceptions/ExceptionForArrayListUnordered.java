package exceptions;

public class ExceptionForArrayListUnordered extends Exception{

    public ExceptionForArrayListUnordered(){
        super("The ArrayList is not ordered");
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
