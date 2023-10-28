package model;

import java.util.ArrayList;
import exceptions.ExceptionFormatOfValueNotAllowed;

/**
 * The Reports class is used for generating and managing reports.
 */
public class Reports {

    private String title;
    private ArrayList<String> category;
    private ArrayList<Object> values;

    
    // The `public Reports(String title, ArrayList<String> Category, ArrayList<Object> values)` is a
    // constructor for the `Reports` class. It is used to create a new instance of the `Reports` class
    // and initialize its instance variables `title`, `category`, and `values` with the values passed
    // as parameters.
    public Reports(String title, ArrayList<String> Category, ArrayList<Object> values) {
        this.title = title;
        this.category = Category;
        this.values = values;
    }

    /**
     * The getCategory() function returns an ArrayList of Strings representing the category.
     * 
     * @return An ArrayList of Strings is being returned.
     */
    public ArrayList<String> getCategory() {
        return this.category;
    }

    /**
     * The function sets the category of an object using an ArrayList of strings.
     * 
     * @param Category The parameter "Category" is an ArrayList of Strings.
     */
    
    public void setCategory(ArrayList<String> Category) {
        this.category = Category;

    }

    /**
     * The function returns an ArrayList of objects.
     * 
     * @return An ArrayList of Objects is being returned.
     */
    public ArrayList<Object> getValues() {
        return this.values;
    }

    
    /**
     * The function sets the values of an ArrayList.
     * 
     * @param values The "values" parameter is an ArrayList of type Object. It is used to set the
     * values of a variable in the class.
     */
    public void setValues(ArrayList<Object> values) {
        this.values = values;
    }

    /**
     * The getTitle() function returns the title of an object.
     * 
     * @return The method is returning the value of the instance variable "title".
     */
    public String getTitle() {
        return this.title;
    }

    
    /**
     * The function sets the title of an object.
     * 
     * @param title The title parameter is a string that represents the title of something, such as a
     * book, a movie, or a document.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The function generates a histogram based on a list of categories and corresponding values.
     * 
     * @return The method returns a String representation of a histogram.
     */
    public String histogramGenerator() throws ExceptionFormatOfValueNotAllowed {

        if (!(values.get(0) instanceof Integer)) {
            throw new ExceptionFormatOfValueNotAllowed(values.get(0).getClass().getSimpleName(), "Integer");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("============================================");
        sb.append("\n" + title + "\n");
        sb.append("============================================");

        for (int i = 0; i < category.size(); i++) {
            sb.append("\ncategory " + category.get(i) + ":  " + values.get(i));
        }
        sb.append("\n\n");
        for (int i = 0; i < category.size(); i++) {
            String bar = "";
            for (int j = 0; j < (Integer) values.get(i); j++) {
                bar += "█";
            }
            sb.append(category.get(i) + "\n" + bar + "\n" + bar + "\n");
        }
        return sb.toString();
    }

    /**
     * The function generates a report with category names and corresponding values, and throws an
     * exception if the first value is not an integer.
     * 
     * @return The method is returning a string that contains a formatted report of state indicators.
     */
    public String statesIndicatorReports() throws ExceptionFormatOfValueNotAllowed {
        String msj = "";
        if (!(values.get(0) instanceof Integer)) {
            throw new ExceptionFormatOfValueNotAllowed(values.get(0).getClass().getSimpleName(), "Integer");
        }

        StringBuilder sb = new StringBuilder();
        msj += ("============================================");
        msj += ("\n" + title + "\n");
        msj += ("============================================\n");
        for (int i = 0; i < category.size(); i++) {
            msj += (category.get(i) + ":  " + values.get(i) + "\n");
        }

        return msj;
    }

    /**
     * The function "listIndicatorReports" generates a formatted string containing a title, categories,
     * and corresponding values.
     * 
     * @return The method is returning a string representation of the indicator reports.
     */
    public String listIndicatorReports() throws ExceptionFormatOfValueNotAllowed {
        String out = "";
        if (!(values.get(0) instanceof String)) {
            throw new ExceptionFormatOfValueNotAllowed(values.get(0).getClass().getSimpleName(), "String");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("==============================================");
        sb.append("\n" + title + "\n");
        sb.append("==============================================\n");

        for (int i = 0; i < category.size(); i++) {
            sb.append("\n - Category " + category.get(i) + " :\n");
            sb.append("\n");
            sb.append(values.get(i));
        }

        return sb.toString();
    }

}