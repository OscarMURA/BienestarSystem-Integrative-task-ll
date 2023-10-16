package test.model;

import model.NutritionalStates;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import model.TypeStates;
import java.util.GregorianCalendar;

public class NutritionalStatesTest {

    private NutritionalStates nutritionalStates;

    private void setUpWeightNormal() {
        Calendar date = new GregorianCalendar(2024, 02, 22);
        nutritionalStates = new NutritionalStates(65.0, 1.65, date);
    }

    private void setUpLowWeight() {
        Calendar date = new GregorianCalendar(2024, 03, 22);
        nutritionalStates = new NutritionalStates(50.0, 1.7, date);
    }

    private void setUpWeightOverweight() {
        Calendar date = new GregorianCalendar(2023, 05, 25);
        nutritionalStates = new NutritionalStates(80.0, 1.75, date);
    }

    private void setUpWeightObesity() {
        Calendar date = new GregorianCalendar(2024, 02, 22);
        nutritionalStates = new NutritionalStates(120.0, 1.8, date);
    }

    private void setUpWeightMorbidObesity() {
        Calendar date = new GregorianCalendar(2024, 02, 22);
        nutritionalStates = new NutritionalStates(150.0, 1.7, date);
    }

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

    @Test
    public void verifyCorrectCalculationOFBIMAndWeightNormal() {
        setUpWeightNormal();
        assertEquals(23.9, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.NORMAL_WEIGHT, nutritionalStates.getType());
    }

    @Test
    public void verifyCorrectCalculationOFBIMAndLowWeight() {
        setUpLowWeight();
        assertEquals(17.3, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.LOW_WEIGHT, nutritionalStates.getType());
    }

    @Test
    public void verifyCorrectCalculationOFBIMAndWeightOverweight() {
        setUpWeightOverweight();
        assertEquals(26.1, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.OVERWEIGHT, nutritionalStates.getType());
    }

    @Test
    public void verifyCorrectCalculationOFBIMAndWeightObesity() {
        setUpWeightObesity();
        assertEquals(37.0, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.OBESITY, nutritionalStates.getType());
    }

    @Test
    public void verifyCorrectCalculationOFBIMAndWeightMorbidObesity() {
        setUpWeightMorbidObesity();
        assertEquals(51.9, nutritionalStates.calculateBIM(), 0.0);
        assertEquals(TypeStates.MORBID_OBESITY, nutritionalStates.getType());
    }

}
