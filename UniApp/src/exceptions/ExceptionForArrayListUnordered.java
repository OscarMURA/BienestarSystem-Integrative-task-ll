package exceptions;

/**
 * The code defines a custom exception class called `ExceptionForArrayListUnordered` that is used to
 * indicate that an ArrayList is not ordered.
 */
public class ExceptionForArrayListUnordered extends Exception{

   // The code is defining a custom exception class called `ExceptionForArrayListUnordered`.
    public ExceptionForArrayListUnordered(){
        super("The ArrayList is not ordered");
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
