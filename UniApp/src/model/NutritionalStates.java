package model;
import java.util.Calendar;

/**
 * The NutritionalStates class is used to represent and manage different nutritional states.
 */
public class NutritionalStates {
    private double weight;
    private double height;
    private Calendar date;

    
    // The `public NutritionalStates(double weight, double height, Calendar date)` is a constructor
    // method for the `NutritionalStates` class. It is used to create a new instance of the
    // `NutritionalStates` class and initialize its `weight`, `height`, and `date` properties with the
    // values passed as arguments to the constructor.
    public NutritionalStates(double weight, double height, Calendar date) {
        this.weight = weight;
        this.height = height;
        this.date = date;
    }

    /**
     * The function returns the weight of an object.
     * 
     * @return The weight of the object.
     */
    public double getWeight() {
        return this.weight;
    }

    
    /**
     * The function sets the weight of an object.
     * 
     * @param weight The weight parameter is a double data type, which means it can hold decimal
     * values. It is used to set the weight of an object or entity.
     */
    public void setWeight(double weight) {
        this.weight = weight;

    }

    /**
     * The getHeight() function returns the height of an object.
     * 
     * @return The method is returning the value of the "height" variable, which is of type double.
     */
    public double getHeight() {
        return this.height;
    }

    
    /**
     * The function sets the height of an object.
     * 
     * @param height The height parameter is a double data type, which means it can store decimal
     * values. It is used to set the height of an object or variable.
     */
    public void setHeight(double height) {
        this.height = height;

    }


    /**
     * The function calculates and returns the Body Mass Index (BMI) based on the weight and height of
     * an individual.
     * 
     * @return The method is returning the calculated BMI (Body Mass Index) value as a double.
     */
    public double getBMI() {
        double bim = 0.0;
        bim = this.weight / (this.height * this.height);
        bim = Math.round(bim * 10.0) / 10.0;
        return bim;
    }

    /**
     * The function returns the date stored in the Calendar object.
     * 
     * @return The method is returning a Calendar object.
     */
    public Calendar getDate() {
        return this.date;
    }

    
    /**
     * The function sets the value of the "date" variable to the provided Calendar object.
     * 
     * @param date The "date" parameter is of type Calendar, which is a class in Java that represents a
     * specific point in time. It can be used to store and manipulate dates and times.
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * The function calculates and returns the nutritional state of an object.
     * 
     * @return The method is returning the nutritional state of an object as a TypeStates object.
     */
    TypeStates calculateTypeStates() {
        TypeStates type = null;
        double bim = getBMI();
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

    /**
     * The function returns the type states by calling the calculateTypeStates() method.
     * 
     * @return The method is returning an object of type TypeStates.
     */
    public TypeStates getType() {
        return calculateTypeStates();
    }
}
