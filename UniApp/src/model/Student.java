package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student> {

    private String id;
    private String name;
    private String lastName;
    private int years;
    private Sex sex;
    private ArrayList<NutritionalStates> nutritionalStates;

    // The `public Student(String id, int years, String name, String lastName, Sex sex)` constructor is
    // initializing a new instance of the `Student` class with the provided parameters. It sets the
    // `id`, `years`, `name`, `lastName`, and `sex` properties of the `Student` object to the
    // corresponding values passed as arguments. It also initializes the `nutritionalStates` property
    // as a new empty `ArrayList`.
    public Student(String id, int years, String name, String lastName, Sex sex) {
        this.id = id;
        this.years = years;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        nutritionalStates = new ArrayList<>();
    }

    /**
     * The function returns the value of the id variable.
     * 
     * @return The method is returning the value of the variable "id".
     */
    public String getId() {
        return id;
    }

    /**
     * The function sets the value of the "id" variable.
     * 
     * @param id The parameter "id" is a String that represents the identifier for an object.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The getName() function returns the name of an object.
     * 
     * @return The method is returning the value of the variable "name".
     */
    public String getName() {
        return name;
    }

    /**
     * The function sets the name of an object.
     * 
     * @param name The name parameter is a String that represents the name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

   /**
    * The function returns the last name of a person.
    * 
    * @return The method is returning the value of the variable "lastName".
    */
    public String getLastName() {
        return lastName;
    }

    /**
     * The function sets the value of the lastName variable.
     * 
     * @param lastName The parameter "lastName" is a String that represents the last name of a person.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The function returns the value of the variable "years".
     * 
     * @return The method is returning the value of the variable "years".
     */
    public int getYears() {
        return years;
    }

    /**
     * The function sets the value of the "years" variable.
     * 
     * @param years The "years" parameter is an integer that represents the number of years.
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * The function returns the sex of an object.
     * 
     * @return The method is returning the value of the variable "sex", which is of type "Sex".
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * The function sets the sex of an object.
     * 
     * @param sex The "sex" parameter is a variable of type "Sex".
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * The function adds a nutritional state to a collection and returns a boolean indicating if the
     * addition was successful.
     * 
     * @param nutritionalState The nutritionalState parameter is an object of the NutritionalStates
     * class.
     * @return The method is returning a boolean value.
     */
    public boolean addNutritionalState(NutritionalStates nutritionalState) {
        return nutritionalStates.add(nutritionalState);
    }

   /**
    * The function returns an ArrayList of NutritionalStates.
    * 
    * @return An ArrayList of NutritionalStates.
    */
    public ArrayList<NutritionalStates> getNutritionalStates() {
        return nutritionalStates;
    }

   /**
    * The toString() function returns a string representation of an object's name, last name, years,
    * and sex.
    * 
    * @return The method is returning a string representation of an object. The string includes the
    * values of the name, lastName, years, and sex variables.
    */
    @Override
    public String toString() {
        String msg="";
        return name + " " + lastName + " " + years + " " + sex; // + " " + nutritionalStates;
    }

    /**
     * The compareTo method compares the id of two Student objects.
     * 
     * @param o The parameter "o" is of type "Student", which means it represents another object of the
     * "Student" class.
     * @return The method is returning the result of comparing the ID of the current student object
     * with the ID of the student object passed as a parameter.
     */
    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }

    /**
     * The function compares two Student objects based on their names and last names.
     * 
     * @param o1 The first student object being compared.
     * @param o2 The parameter "o2" is an object of the class "Student".
     * @return The method is returning an integer value, which represents the comparison result between
     * two Student objects.
     */
    @Override
    public  int compare(Student o1, Student o2) {
        int criteria1 = o1.name.compareTo(o2.name);
        int criteria2 = o1.lastName.compareTo(o2.lastName);
        if (criteria1 == 0) {
            criteria1=criteria2;
        }
        return criteria1;
    }

    /**
     * The function "toCSV" returns a string representation of an object's attributes separated by
     * semicolons.
     * 
     * @return The method is returning a string in CSV format.
     */
    public String toCSV() {
        return name + ";" + lastName + ";" + years + ";" + id + ";" + sex + ";" + nutritionalStates.get(0).getWeight()
                + ";" + nutritionalStates.get(1).getWeight() + ";" + nutritionalStates.get(1).getHeight() + ";"
                + nutritionalStates.get(0).getBMI() + ";" + nutritionalStates.get(1).getBMI();
    }

    /**
     * The formatList function returns a formatted string containing information about a person's code,
     * name, age, sex, weight, height, and BMI at a specific date index.
     * 
     * @param dateIndex The `dateIndex` parameter is an integer that represents the index of a specific
     * date in the `nutritionalStates` list.
     * @return The method is returning a formatted string that includes the code, name, last name, age,
     * sex, weight, height, and BMI of a person at a specific date index.
     */
    public String formatList(int dateIndex) {
        String msg="";
        msg +="Code: "+id+" Name: "+name + " " + lastName + " Age: " + years + " Sex:" + sex + " weight:" + nutritionalStates.get(dateIndex).getWeight() +" Height: " + nutritionalStates.get(dateIndex).getHeight() +" BMI: "+ nutritionalStates.get(dateIndex).getBMI();
        return msg;
    }

    /**
     * The function "indicatorList" returns a string containing the code, name, age, sex, BMI for
     * September, BMI for April, and average BMI of a person.
     * 
     * @return The method is returning a string that includes the code, name, last name, age, sex, BMI
     * for September, BMI for April, and the average BMI.
     */
    public String indicatorList(){
        double sep = nutritionalStates.get(0).getBMI();
        double apr = nutritionalStates.get(1).getBMI();
        return "Code: "+id+" Name: "+name + " " + lastName + " Age: " + years + " Sex:" + sex+" BIM (Sep)"+sep+" BIM(Abr)"+apr+"   AverageBMI" +averageBMI();
    }
/**
 * The function calculates the average BMI (Body Mass Index) from a list of nutritional states.
 * 
 * @return The method is returning the average BMI (Body Mass Index) of the nutritional states in the
 * list.
 */

    public double averageBMI(){
        double averageBMI = 0;
        for (int i = 0; i < nutritionalStates.size(); i++) {
            averageBMI += nutritionalStates.get(i).getBMI();
        }
        averageBMI = averageBMI / nutritionalStates.size();
        return averageBMI;
    }
}
