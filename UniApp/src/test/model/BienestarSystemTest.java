package test.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import model.BienestarSystem;
import model.Student;

public class BienestarSystemTest {
    private BienestarSystem bienestarSystem;

    @Test
    public void setUp() {
        bienestarSystem = new BienestarSystem();
    }


    @Test
    public void testAddStudents() {
        setUp();
        bienestarSystem.loadStudentsJson();
        //System.out.println(bienestarSystem.indicatorChangesNutritionalStates());
        System.out.println(bienestarSystem.histogramGenerator());
        //System.out.println(bienestarSystem.indicatorListChangeNutritionalStates(1));
    }

    @Test
    public void testAddNutritionalStates() {

    }

    @Test
    public void testRemovedStudent() {

    }

    @Test
    public void testSearchStudent() {

    }

    @Test
    public void testModifyStudent() {

    }

    @Test
    public void testModifyNutritionalStudent() {

    }
}