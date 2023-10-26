package test.model;

import model.NutritionalStates;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Calendar;
import model.TypeStates;
import java.util.GregorianCalendar;

public class NutritionalStatesTest {

    private NutritionalStates nutritionalStates;


    /**
     * This method sets up the scenario for the tests of the nutritional states with a normal weight
     */
    private void setUpWeightNormal() {
        Calendar date = new GregorianCalendar(2024, 02, 22);
        nutritionalStates = new NutritionalStates(65.0, 1.65, date);
    }

    /**
     * This method sets up the scenario for the tests of the nutritional states with a low weight
     */
    private void setUpLowWeight() {
        Calendar date = new GregorianCalendar(2024, 03, 22);
        nutritionalStates = new NutritionalStates(50.0, 1.7, date);
    }

    /**
     * This method sets up the scenario for the tests of the nutritional states with a overweight
     */
    private void setUpWeightOverweight() {
        Calendar date = new GregorianCalendar(2023, 05, 25);
        nutritionalStates = new NutritionalStates(80.0, 1.75, date);
    }

    /**
     * This method sets up the scenario for the tests of the nutritional states with a obesity
     */
    private void setUpWeightObesity() {
        Calendar date = new GregorianCalendar(2024, 02, 22);
        nutritionalStates = new NutritionalStates(120.0, 1.8, date);
    }

    /**
     * This method sets up the scenario for the tests of the nutritional states with a morbid obesity
     */
    private void setUpWeightMorbidObesity() {
        Calendar date = new GregorianCalendar(2024, 02, 22);
        nutritionalStates = new NutritionalStates(150.0, 1.7, date);
    }

    /**
     * This methiod tests the getters of the nutritional states
     */
    @Test
    public void getsTestOfTheNutritionalStates() {
        setUpWeightNormal();
        Calendar date = new GregorianCalendar(2024, 02, 22);
        boolean equalsWeight = 65.0 == nutritionalStates.getWeight();
        boolean equalsDate = date.getTime().equals(nutritionalStates.getDate().getTime());
        boolean equalsHeight = 1.65 == nutritionalStates.getHeight();

        assertTrue(equalsWeight);
        assertTrue(equalsHeight);
        assertTrue(equalsDate);
    }

    /**
     * This method tests the setters of the nutritional states.
     * Also, it tests the getters of the nutritional states,
     * because it is necessary to verify that the setters work correctly
     */
    @Test
    public void setsTestOfTheNutrituonalStates() {
        setUpWeightNormal();
        Calendar date = new GregorianCalendar(2023, 05, 22);
        double weight = 80.0;
        double height = 1.75;
        nutritionalStates.setWeight(weight);
        nutritionalStates.setHeight(height);
        nutritionalStates.setDate(date);
        boolean equalsWeight = weight == nutritionalStates.getWeight();
        boolean equalsDate = date.getTime().equals(nutritionalStates.getDate().getTime());
        boolean equalsHeight = height == nutritionalStates.getHeight();
        assertTrue(equalsWeight);
        assertTrue(equalsHeight);
        assertTrue(equalsDate);
    }

    /**
     * This method tests the calculation of the BIM and the type of the nutritional states
     * It also tests the getters of the nutritional states, because it is necessary to verify that the setters work correctly
     */
    @Test
    public void verifyCorrectCalculationOfTheBIMAndTypeNutritional() {
        setUpWeightNormal();
        Calendar date = new GregorianCalendar(2023, 05, 22);
        double weight = 80.0;
        double height = 1.75;
        nutritionalStates.setWeight(weight);
        nutritionalStates.setHeight(height);
        nutritionalStates.setDate(date);

        assertEquals(26.1, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.OVERWEIGHT, nutritionalStates.getType());
    }

    /**
     * This method tests the calculation of the BIM and the type of the nutritional states with a Normal weight
     */
    @Test
    public void verifyCorrectCalculationOFBIMAndWeightNormal() {
        setUpWeightNormal();
        assertEquals(23.9, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.NORMAL_WEIGHT, nutritionalStates.getType());
    }

    /**
     * This method tests the calculation of the BIM and the type of the nutritional states with a Low weight
     */
    @Test
    public void verifyCorrectCalculationOFBIMAndLowWeight() {
        setUpLowWeight();
        assertEquals(17.3, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.LOW_WEIGHT, nutritionalStates.getType());
    }

    /**
     * This method tests the calculation of the BIM and the type of the nutritional states with a Overweight
     */
    @Test
    public void verifyCorrectCalculationOFBIMAndWeightOverweight() {
        setUpWeightOverweight();
        assertEquals(26.1, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.OVERWEIGHT, nutritionalStates.getType());
    }

    /**
     * This method tests the calculation of the BIM and the type of the nutritional states with a Obesity
     */
    @Test
    public void verifyCorrectCalculationOFBIMAndWeightObesity() {
        setUpWeightObesity();
        assertEquals(37.0, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.OBESITY, nutritionalStates.getType());
    }

    /**
     * This method tests the calculation of the BIM and the type of the nutritional states with a Morbid Obesity
     */
    @Test
    public void verifyCorrectCalculationOFBIMAndWeightMorbidObesity() {
        setUpWeightMorbidObesity();
        assertEquals(51.9, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.MORBID_OBESITY, nutritionalStates.getType());
    }

}
