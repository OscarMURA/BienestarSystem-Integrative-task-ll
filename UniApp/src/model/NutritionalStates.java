package model;
import java.util.Calendar;

public class NutritionalStates {
    private double weight;
    private double height;
    private Calendar date;

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
        double bim = 0.0;
        bim = this.weight / (this.height * this.height);
        bim = Math.round(bim * 10.0) / 10.0;
        return bim;
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
        TypeStates type = null;
        double bim = calculateBIM();
        if (bim < 18.5) {
            type = TypeStates.LOW_WEIGHT;
        } else if (bim >= 18.5 && bim <= 24.9) {
            type = TypeStates.NORMAL_WEIGHT;
        } else if (bim >= 25 && bim <= 29.9) {
            type = TypeStates.OVERWEIGHT;
        } else if (bim >= 30 && bim < 40.0) {
            type = TypeStates.OBESITY;
        }else{
            type = TypeStates.MORBID_OBESITY;
        }
        return type;
    }

    public TypeStates getType() {
        return calculateTypeStates(this.weight, this.height);
    }


}
