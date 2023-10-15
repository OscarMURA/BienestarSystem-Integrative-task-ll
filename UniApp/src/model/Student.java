package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar;

public class Student {

    private String id;
    private String name;
    private String lastName;
    private int years;
    private Sex sex;
    private ArrayList<NutritionalStates> nutritionalStates;

    /**
     *
     * @param id
     * @param years
     * @param name
     * @param lastName
     */
    public Student(String id, int years, String name, String lastName, Sex sex) {
        this.id = id;
        this.years = years;
        this.name = name;
        this.lastName=lastName;
        this.sex=sex;
        nutritionalStates = new ArrayList<NutritionalStates>();
    }

    public String getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void getLastName() {
        // getLastName
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param LastName
     */
    public void setLastName(int LastName) {
        // setLastName
        throw new UnsupportedOperationException();
    }

    public int getYears() {
        return this.years;
    }

    /**
     *
     * @param years
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     *
     * @param dates
     */
    public boolean addNutritionalStates(NutritionalStates dates) {
        // addNutritionalStates
        throw new UnsupportedOperationException();
    }

    public ArrayList<NutritionalStates> getNutritionalStates() {
        return this.nutritionalStates;
    }

}