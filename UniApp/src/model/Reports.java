package model;
import java.util.ArrayList;
import exceptions.ExceptionFormatOfValueNotAllowed;
public class Reports {

    private String title;
    private ArrayList<String> category;
    private ArrayList<Object> values;

    /**
     *
     * @param title
     * @param Category
     */
    public Reports(String title, ArrayList<String> Category, ArrayList<Object> values) {
        this.title = title;
        this.category = Category;
        this.values = values;
    }

    public ArrayList<String> getCategory() {
        return this.category;
    }

    /**
     *
     * @param Category
     */
    public void setCategory(ArrayList<String> Category) {
        this.category = Category;

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



    public String histogramGenerator() throws ExceptionFormatOfValueNotAllowed {

        if(!(values.get(0) instanceof Integer)){
            throw new ExceptionFormatOfValueNotAllowed(values.get(0).getClass().getSimpleName(), "Integer");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("============================================");
        sb.append("\n"+title+"\n");
        sb.append("============================================");

        for (int i = 0; i < category.size(); i++) {
            sb.append("\ncategory "+category.get(i)+":\t"+values.get(i));
        }
        sb.append("\n\n");
        for (int i = 0; i < category.size(); i++) {
            String bar="";
            for (int j = 0; j < (Integer) values.get(i); j++) {
                bar+="█";
            }
            sb.append(category.get(i)+"\n"+bar+"\n"+bar+"\n");
        }
        return sb.toString();
    }

    public String statesIndicatorReports() throws ExceptionFormatOfValueNotAllowed {
        String msj="";
        if(!(values.get(0) instanceof Integer)){
            throw new ExceptionFormatOfValueNotAllowed(values.get(0).getClass().getSimpleName(), "Integer");
        }

        StringBuilder sb = new StringBuilder();
        msj+=("============================================");
        msj+=("\n"+title+"\n");
        msj+=("============================================\n");
        for (int i = 0; i < category.size(); i++) {
            msj+=(category.get(i)+":\t"+values.get(i)+"\n");
        }

        return msj;
    }

    public String listIndicatorReports() throws ExceptionFormatOfValueNotAllowed {
        String out="";
        if(!(values.get(0) instanceof String)){
            throw new ExceptionFormatOfValueNotAllowed(values.get(0).getClass().getSimpleName(), "String");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("============================================");
        sb.append("\n"+title+"\n");
        sb.append("============================================");

        for (int i = 0; i < category.size(); i++) {
            sb.append("\n*Category "+category.get(i));
            sb.append("\n");
            sb.append(":\t"+values.get(i));
        }

        return sb.toString();
    }

}