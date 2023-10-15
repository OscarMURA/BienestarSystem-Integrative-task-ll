package model;

import java.util.Calendar;
import java.util.ArrayList;

public class BienestarSystem {


    private ArrayList<Student> students;
    private FileManager fileManager;
    private Reports reports;
    public  BienestarSystem() {
        fileManager= FileManager.getInstance();
        students = new ArrayList<Student>();
    }

    /**
     *
     * @param id
     * @param years
     * @param name
     * @param lastName
     */
    public String addStudents(String id, int years, String name, String lastName, String sex) {
        // addStudents
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param weight
     * @param height
     * @param date
     */
    public String addNutritionalStates(double weight, double height, Calendar date) {
        // addNutritionalStates
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public String removedStudent(String id) {
        // removedStudent
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public Student searchStudent(String id) {
        // searchStudent
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     * @param years
     * @param name
     * @param lastName
     */
    public String modifyStudent(String id, int years, String name, String lastName, String sex) {
        // modifyStudent
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     * @param weight
     * @param height
     * @param date
     */
    public String modifyNutritionalStudent(String id, double weight, double height, Calendar date) {
        // modifyNutritionalStudent
        throw new UnsupportedOperationException();
    }

    public String histogramGenerator() {
        // histogramGenerator
        throw new UnsupportedOperationException();
    }

    public String statesIndicatorReports() {
        // statesIndicatorReports
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param typeOrden
     */
    public String listIndicatorReport(int typeOrden) {
        // listIndicatorReport
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param typeOrden
     */
    public String listOrdenedBMI(int typeOrden) {
        // listOrdenedBMI
        throw new UnsupportedOperationException();
    }



}
