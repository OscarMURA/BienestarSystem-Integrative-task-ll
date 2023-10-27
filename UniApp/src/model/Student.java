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

    public Student(String id, int years, String name, String lastName, Sex sex) {
        this.id = id;
        this.years = years;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        nutritionalStates = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean addNutritionalState(NutritionalStates nutritionalState) {
        return nutritionalStates.add(nutritionalState);
    }

    public ArrayList<NutritionalStates> getNutritionalStates() {
        return nutritionalStates;
    }

    @Override
    public String toString() {
        String msg="";
        return name + " " + lastName + " " + years + " " + sex; // + " " + nutritionalStates;
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public  int compare(Student o1, Student o2) {
        int criteria1 = o1.name.compareTo(o2.name);
        int criteria2 = o1.lastName.compareTo(o2.lastName);
        if (criteria1 == 0) {
            criteria1=criteria2;
        }
        return criteria1;
    }

    public String toCSV() {
        return name + ";" + lastName + ";" + years + ";" + id + ";" + sex + ";" + nutritionalStates.get(0).getWeight()
                + ";" + nutritionalStates.get(1).getWeight() + ";" + nutritionalStates.get(1).getHeight() + ";"
                + nutritionalStates.get(0).getBMI() + ";" + nutritionalStates.get(1).getBMI();
    }

    public String formatList(int dateIndex) {
        String msg="";
        msg +="Code: "+id+" Name: "+name + " " + lastName + " Age: " + years + " Sex:" + sex + " weight:" + nutritionalStates.get(dateIndex).getWeight() +" Height: " + nutritionalStates.get(dateIndex).getHeight() +" BMI: "+ nutritionalStates.get(dateIndex).getBMI();
        return msg;
    }

    public String indicatorList(){
        double sep = nutritionalStates.get(0).getBMI();
        double apr = nutritionalStates.get(1).getBMI();
        return "Code: "+id+" Name: "+name + " " + lastName + " Age: " + years + " Sex:" + sex+" BIM (Sep)"+sep+" BIM(Abr)"+apr+"   AverageBMI" +averageBMI();
    }

    public double averageBMI(){
        double averageBMI = 0;
        for (int i = 0; i < nutritionalStates.size(); i++) {
            averageBMI += nutritionalStates.get(i).getBMI();
        }
        averageBMI = averageBMI / nutritionalStates.size();
        return averageBMI;
    }





}
