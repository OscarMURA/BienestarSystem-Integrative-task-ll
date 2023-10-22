package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student>{

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

    public String toString() {
        return name + " " + lastName + " " + years + " " + sex; // + " " + nutritionalStates;
    }
        @Override
        public int compareTo(Student o) {
            return this.id.compareTo(o.id);
        }
        @Override
        public int compare(Student o1, Student o2) {
            return this.id.compareTo(o2.id);
        }

        public String toCSV() {
            return name + ";" + lastName + ";" + years + ";"+id+";"+sex+";"+nutritionalStates.get(0).getWeight()
                    +";"+nutritionalStates.get(1).getWeight()+";"+nutritionalStates.get(1).getHeight()+";"+nutritionalStates.get(0).calculateBIM()+ ";" + nutritionalStates.get(1).calculateBIM();
        }
}
