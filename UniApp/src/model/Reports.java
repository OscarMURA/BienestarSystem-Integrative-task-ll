package model;
import java.util.ArrayList;
import exceptions.ExceptionFormatOfValueNotAllowed;
public class Reports {

    private String title;
    private String[] Category;
    private ArrayList<Object> values;

    /**
     *
     * @param title
     * @param Category
     */
    public Reports(String title, String[] Category, ArrayList<Object> values) {
        this.title = title;
        this.Category = Category;
        this.values = values;
    }

    public String[] getCategory() {
        // getCategory
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param Category
     */
    public void setCategory(String[] Category) {
        // setCategory
        throw new UnsupportedOperationException();
    }

    public ArrayList<Object> getValues() {
        return this.values;
    }

    /**
     *
     * @param values
     */
    public void setValues(ArrayList<Object> values) {
        this.values = values;
    }

    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String histogramGenerator() {
        // histogramGenerator
        throw new UnsupportedOperationException();
    }

    public String statesIndicatorReports() {
        // statesIndicatorReports
        throw new UnsupportedOperationException();
    }

    public String listIndicatorReports() {
        // listIndicatorReports
        throw new UnsupportedOperationException();
    }

}