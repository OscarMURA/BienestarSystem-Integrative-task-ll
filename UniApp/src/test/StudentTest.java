package test;

import model.Student;
import model.Sex;
import model.NutritionalStates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        student = new Student("123", 20, "John", "Doe", Sex.M);
    }

    @Test
    public void testGetId() {
        assertEquals("123", student.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("John", student.getName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", student.getLastName());
    }

    @Test
    public void testGetYears() {
        assertEquals(20, student.getYears());
    }

    @Test
    public void testGetSex() {
        assertEquals(Sex.M, student.getSex());
    }

    @Test
    public void testAddNutritionalState() {
        NutritionalStates ns = new NutritionalStates(70.0, 1.75, null);
        assertTrue(student.addNutritionalState(ns));
        ArrayList<NutritionalStates> nsList = student.getNutritionalStates();
        assertTrue(nsList.contains(ns));
    }

    @Test
    public void testGetters() {
        assertEquals("123", student.getId());
        assertEquals("John", student.getName());
        assertEquals("Doe", student.getLastName());
        assertEquals(20, student.getYears());
        assertEquals(Sex.M, student.getSex());
    }

    @Test
    public void testSetters() {
        student.setId("789012");
        student.setName("Alice");
        student.setLastName("Smith");
        student.setYears(25);
        student.setSex(Sex.F);

        assertEquals("789012", student.getId());
        assertEquals("Alice", student.getName());
        assertEquals("Smith", student.getLastName());
        assertEquals(25, student.getYears());
        assertEquals(Sex.F, student.getSex());
    }

}