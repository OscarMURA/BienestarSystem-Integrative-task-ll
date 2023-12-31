package test.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import model.Student;
import model.NutritionalStates;
import model.Sex;
import java.util.GregorianCalendar;

/**
 * The StudentTest class is used to test the functionality of the Student class.
 */
public class StudentTest {
    private Student student;

    @Before
    public void setUpScenary1() {
        student = new Student("A00584564", 20, "Jaime", "Smith", Sex.M);
    }

    /**
     * The setUpScenary2 function sets up a test scenario by creating a student object and adding two
     * nutritional states to it.
     */
    @Before
    public void setUpScenary2() {
        student = new Student("A00399954", 21, "Jane", "Doe", Sex.F);
        student.addNutritionalState(new NutritionalStates(65, 1.60, Calendar.getInstance()));
        student.addNutritionalState(new NutritionalStates(70, 1.65, Calendar.getInstance()));
    }

    /**
     * The testGettersAndSetters function tests the getters and setters of a Student object.
     */
    @Test
    public void testGettersAndSetters() {
        assertEquals("A00584564", student.getId());
        assertEquals("Jaime", student.getName());
        assertEquals("Smith", student.getLastName());
        assertEquals(20, student.getYears());
        assertEquals(Sex.M, student.getSex());

        student.setId("A00399922");
        student.setName("Alice");
        student.setLastName("Martinez");
        student.setYears(25);
        student.setSex(Sex.F);

        assertEquals("A00399922", student.getId());
        assertEquals("Alice", student.getName());
        assertEquals("Martinez", student.getLastName());
        assertEquals(25, student.getYears());
        assertEquals(Sex.F, student.getSex());
    }

    /**
     * The testAddNutritionalState function tests if a nutritional state can be added to a student and
     * if the size of the nutritional states list increases by 1.
     */
    @Test
    public void testAddNutritionalState() {
        setUpScenary1();
        NutritionalStates state = new NutritionalStates(70, 1.70, Calendar.getInstance());
        assertTrue(student.addNutritionalState(state));
        assertEquals(1, student.getNutritionalStates().size());
    }

    /**
     * The testToString function tests the toString method of a Student object.
     */
    /**
     * The testToString function tests the toString method of a Student object.
     */
    @Test
    public void testToString() {
        setUpScenary1();
        String expected = "Jaime Smith 20 M";
        assertEquals(expected, student.toString());
    }

    /**
     * The testCompare function tests the compare method of the Student class by comparing two student
     * objects and asserting that the result is less than 0.
     */
    @Test
    public void testCompare() {
        Student student1 = new Student("A00584564", 20, "Jaime", "Smith", Sex.M);
        Student student2 = new Student("A00399954", 21, "Jane", "Doe", Sex.F);
        assertTrue(student1.compare(student1, student2) < 0);
    }

    /**
     * The function "verifyDatesCSV" tests the functionality of converting a Student object to a CSV
     * string.
     */
    @Test
    public void verifyDatesCSV() {
        Student student = new Student("A00584485", 20, "John", "Jaimes", Sex.M);
        NutritionalStates state1 = new NutritionalStates(70, 1.82, new GregorianCalendar(2023, Calendar.APRIL, 1));
        NutritionalStates state2 = new NutritionalStates(75, 1.82, new GregorianCalendar(2023, Calendar.APRIL, 1));
        student.addNutritionalState(state1);
        student.addNutritionalState(state2);

        String expected = "John;Jaimes;20;A00584485;M;70.0;75.0;1.82;21.1;22.6";
        String csv = student.toCSV();
        assertEquals(expected, csv);

    }

    /**
     * The testFormatList function tests the formatList method of the Student class by creating a
     * student object, adding a nutritional state, and comparing the formatted output with the expected
     * output.
     */
    @Test
    public void testFormatList() {
        Student student = new Student("A00245865", 30, "Alice", "Smith", Sex.F);
        NutritionalStates state = new NutritionalStates(65, 1.60, new GregorianCalendar(2020, Calendar.SEPTEMBER, 1));
        student.addNutritionalState(state);

        String expected = "Code: A00245865 Name: Alice Smith Age: 30 Sex:F weight:65.0 Height: 1.6 BMI: 25.4";
        String formatted = student.formatList(0);
        assertEquals(expected, formatted);
    }

    /**
     * The testIndicatorList function tests the indicatorList method of the Student class by creating a
     * student object, adding nutritional states to it, and comparing the expected output with the
     * actual output.
     */
    @Test
    public void testIndicatorList() {
        Student student = new Student("A00325486", 35, "Bob", "Johnson", Sex.M);
        NutritionalStates state1 = new NutritionalStates(70, 1.70, new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        NutritionalStates state2 = new NutritionalStates(75, 1.70, new GregorianCalendar(2023, Calendar.APRIL, 1));
        student.addNutritionalState(state1);
        student.addNutritionalState(state2);

        String expected = "Code: A00325486 Name: Bob Johnson Age: 35 Sex:M BIM (Sep)24.2 BIM(Abr)26.0   AverageBMI25.1";
        String indicator = student.indicatorList();
        assertEquals(expected, indicator);
    }

   /**
    * The testAverageBMI function tests the averageBMI method of the Student class by creating a
    * Student object, adding two NutritionalStates to it, and comparing the expected average BMI with
    * the calculated average BMI.
    */
    @Test
    public void testAverageBMI() {
        Student student = new Student("A00425496", 28, "Eve", "Rodriguez", Sex.F);
        NutritionalStates state1 = new NutritionalStates(70, 1.70, new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        NutritionalStates state2 = new NutritionalStates(75, 1.70, new GregorianCalendar(2023, Calendar.APRIL, 1));
        student.addNutritionalState(state1);
        student.addNutritionalState(state2);

        double expectedAverage = (24.22 + 26.0) / 2;
        double calculatedAverage = student.averageBMI();
        assertEquals(expectedAverage, calculatedAverage, 0.01);
    }
}
