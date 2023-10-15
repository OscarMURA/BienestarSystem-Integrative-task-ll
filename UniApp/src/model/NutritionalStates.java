package model;
import java.util.Calendar;

public class NutritionalStates {
    private double weight;

    private double height;
    private Calendar date;
    private TypeStates type;

    /**
     *
     * @param weight
     * @param height
     * @param date
     */
    public NutritionalStates(double weight, double height, Calendar date) {
        this.weight = weight;
        this.height = height;
        this.date = date;
        this.type = calculateTypeStates(weight, height);
    }



    public double getWeight() {
        return this.weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateBIM() {
        // calculateBIM
        throw new UnsupportedOperationException();
    }

    public Calendar getDate() {
        return this.date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     *
     * @param weight
     * @param height
     */
    private TypeStates calculateTypeStates(double weight, double height) {
        // calculateTypeStates
        throw new UnsupportedOperationException();
    }

    public TypeStates getType() {
        // getType
        throw new UnsupportedOperationException();
    }

}
