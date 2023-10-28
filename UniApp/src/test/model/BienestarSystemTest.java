package test.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.BienestarSystem;

/**
 * The BienestarSystemTest class is used for testing the functionality of the BienestarSystem class.
 */
public class BienestarSystemTest {
    private BienestarSystem bienestarSystem;

    @Test
   // The `setUpWithStudents()` method is used to set up the initial state of the `bienestarSystem`
   // object by adding a list of students with their respective information (ID, age, first name, last
   // name, and gender).
    public void setUpWithStudents() {
        bienestarSystem = new BienestarSystem();
        bienestarSystem.addStudents("A00000001", 18, "Ana", "Lopez", "F");
        bienestarSystem.addStudents("A00000002", 20, "Carlos", "Gonzalez", "M");
        bienestarSystem.addStudents("A00000003", 21, "Maria", "Rodriguez", "F");
        bienestarSystem.addStudents("A00000004", 17, "David", "Martinez", "M");
        bienestarSystem.addStudents("A00000005", 22, "Laura", "Sanchez", "F");
        bienestarSystem.addStudents("A00000006", 24, "Pedro", "Lopez", "M");
        bienestarSystem.addStudents("A00000007", 19, "Sofia", "Garcia", "F");
        bienestarSystem.addStudents("A00000008", 23, "Diego", "Perez", "M");
        bienestarSystem.addStudents("A00000009", 25, "Carmen", "Fernandez", "F");
        bienestarSystem.addStudents("A00000010", 16, "Manuel", "Lopez", "M");
        bienestarSystem.addStudents("A00000011", 20, "Isabel", "Gutierrez", "F");
        bienestarSystem.addStudents("A00000012", 18, "Javier", "Torres", "M");
        bienestarSystem.addStudents("A00000013", 21, "Paula", "Jimenez", "F");
        bienestarSystem.addStudents("A00000014", 17, "Jose", "Sanchez", "M");
        bienestarSystem.addStudents("A00000015", 22, "Maria", "Garcia", "F");
        bienestarSystem.addStudents("A00000016", 24, "Juan", "Martinez", "M");
        bienestarSystem.addStudents("A00000017", 19, "Sara", "Sanchez", "F");

    }

    /**
     * The function sets up nutritional states for multiple students in the bienestarSystem.
     */
    @Test
    public void setUpWithNutritionalStates() {
        // Estudiante A00000001
        setUpWithStudents();
        bienestarSystem.addNutritionalStateToStudent("A00000001", 46.0, 1.70,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000001", 58.0, 1.70,
                new GregorianCalendar(2023, Calendar.APRIL, 1));
        // Estudiante A00000002
        bienestarSystem.addNutritionalStateToStudent("A00000002", 48.0, 1.75,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000002", 72.0, 1.75,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000003
        bienestarSystem.addNutritionalStateToStudent("A00000003", 85.0, 1.80,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000003", 67.0, 1.80,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000004
        bienestarSystem.addNutritionalStateToStudent("A00000004", 50.0, 1.65,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000004", 48.0, 1.65,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000005
        bienestarSystem.addNutritionalStateToStudent("A00000005", 95.0, 1.75,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000005", 97.0, 1.75,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000006
        bienestarSystem.addNutritionalStateToStudent("A00000006", 100.0, 1.70,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000006", 78.0, 1.70,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000007
        bienestarSystem.addNutritionalStateToStudent("A00000007", 82.0, 1.75,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000007", 81.0, 1.75,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000008
        bienestarSystem.addNutritionalStateToStudent("A00000008", 150.0, 1.70,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000008", 100.0, 1.70,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000009
        bienestarSystem.addNutritionalStateToStudent("A00000009", 55.0, 1.68,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000009", 56.0, 1.68,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000010
        bienestarSystem.addNutritionalStateToStudent("A00000010", 101.0, 1.72,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000010", 80.0, 1.72,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000011
        bienestarSystem.addNutritionalStateToStudent("A00000011", 63.0, 1.68,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000011", 110.0, 1.68,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000012
        bienestarSystem.addNutritionalStateToStudent("A00000012", 95.0, 1.75,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000012", 70.0, 1.75,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000013
        bienestarSystem.addNutritionalStateToStudent("A00000013", 68.0, 1.68,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000013", 87.0, 1.68,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000014
        bienestarSystem.addNutritionalStateToStudent("A00000014", 70.0, 1.73,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000014", 90.0, 1.73,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000015
        bienestarSystem.addNutritionalStateToStudent("A00000015", 80.0, 1.70,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000015", 69.0, 1.70,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000016
        bienestarSystem.addNutritionalStateToStudent("A00000016", 85.0, 1.80,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000016", 83.0, 1.80,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

        // Estudiante A00000017
        bienestarSystem.addNutritionalStateToStudent("A00000017", 52.0, 1.65,
                new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        bienestarSystem.addNutritionalStateToStudent("A00000017", 50.0, 1.65,
                new GregorianCalendar(2023, Calendar.APRIL, 1));

    }

    /**
     * This method tests the getters of the nutritional states
     */
    @Test
    public void testAddAStudentsCorrectly() {
        setUpWithStudents();
        assertEquals(bienestarSystem.addStudents("A000000018", 18, "Ana", "Lopez", "F"),
            "\nStudent added successfully.");
        assertEquals(18, bienestarSystem.getStudents().size());
    }

    /**
     * The testAddStudentAndNoPermitAddIdRepeated function tests that adding a student with a repeated
     * ID returns an error message and does not add the student to the system.
     */
    @Test
    public void testAddStudentAndNoPermitAddIdRepeated() {
        setUpWithStudents();
        assertEquals(bienestarSystem.addStudents("A00000001", 18, "Ana", "Lopez", "F"),
                "The id of the student already exist");
        assertEquals(17, bienestarSystem.getStudents().size());
    }

    /**
     * The testAddNutritionalStates function tests the functionality of adding nutritional states to a
     * student in the bienestarSystem.
     */
    @Test
    public void testAddNutritionalStates() {
        setUpWithStudents();
        assertEquals(
                bienestarSystem.addNutritionalStateToStudent("A00000001", 46.0, 1.70,
                        new GregorianCalendar(2022, Calendar.SEPTEMBER, 1)),
                "\nNutritional status added correctly");
        assertEquals(1, bienestarSystem.getStudents().get(0).getNutritionalStates().size());
        assertEquals(bienestarSystem.addNutritionalStateToStudent("A00000001", 58.0, 1.70,
                new GregorianCalendar(2023, Calendar.APRIL, 1)), "\nNutritional status added correctly");
        assertEquals(2, bienestarSystem.getStudents().get(0).getNutritionalStates().size());
    }

    /**
     * The testRemovedStutentThatNotExists function tests the behavior of the removedStudent method
     * when trying to remove a student that does not exist.
     */
    @Test
    public void testRemovedStutentThatNotExists() {
        setUpWithStudents();
        assertEquals(bienestarSystem.removedStudent("A000000018"), "\nStudent not found.");
        assertEquals(17, bienestarSystem.getStudents().size());
    }

    //The `testRemovedStutentThatExists()` method is a unit test that checks the functionality of the
    // `removedStudent()` method in the `BienestarSystem` class.
    @Test
    public void testRemovedStutentThatExists() {
        setUpWithStudents();
        assertEquals(bienestarSystem.removedStudent("A00000001"), "\nStudent removed successfully.");
        assertEquals(16, bienestarSystem.getStudents().size());
    }

    /**
     * The testModifyStudentThatNoExist function tests the behavior of the modifyStudent method when
     * trying to modify a student that does not exist.
     */
    @Test
    public void testModifyStudentThatNoExist() {
        setUpWithStudents();
        String id = "A000000018";
        assertEquals(bienestarSystem.modifyStudent(id, 22, "Ana", "Lopez", "F"),
                "\nThe student with the ID " + id + " does not exist.\n");
        assertEquals(17, bienestarSystem.getStudents().size());
    }

    /**
     * The testModifyStudentThatExist function tests the modifyStudent method in the bienestarSystem
     * class by modifying the attributes of an existing student and checking if the modifications were
     * successful.
     */
    @Test
    public void testModifyStudentThatExist() {
        setUpWithStudents();
        String id = "A00000001";
        String modifys = bienestarSystem.modifyStudent(id, 22, "Ana Maria", "Lopez Gonzales", "O");
        String modifyCorrect = "\nSuccessfully modified attributes:\n" + "\nModified year." + "\nModified name."
                + "\nModified last name." + "\nModified Sex" + "\n" + "\n";
        assertEquals(modifyCorrect, modifys);
        assertEquals(17, bienestarSystem.getStudents().size());
    }


    /**
     * The testModifyNutritionalStudentToStudentThatNoExist function tests the modifyNutritionalStudent
     * method in the bienestarSystem class by passing an ID of a student that does not exist.
     */
    @Test
    public void testModifyNutritionalStudentToStudentThatNoExist() {
        setUpWithNutritionalStates();
        String id = "A000000018";
        assertEquals(bienestarSystem.modifyNutritionalStudent(id, 46.0, 1.70, new GregorianCalendar(2022, Calendar.SEPTEMBER, 1)),"Student not found.");
    }

    /**
     * The testModifyNutritionalAtSeptember function tests the modification of a student's nutritional
     * state at a specific date in September.
     */
    @Test
    public void testModifyNutritionalAtSeptember() {
        setUpWithNutritionalStates();
        String id = "A00000001";
        assertEquals(bienestarSystem.modifyNutritionalStudent(id, 46.0, 1.70, new GregorianCalendar(2022, Calendar.SEPTEMBER, 1)),"Nutritional state modified successfully.");
        assertEquals(46.0, bienestarSystem.getStudents().get(0).getNutritionalStates().get(0).getWeight(), 0.0);
        assertEquals(1.70, bienestarSystem.getStudents().get(0).getNutritionalStates().get(0).getHeight(), 0.0);
        assertEquals(new GregorianCalendar(2022, Calendar.SEPTEMBER, 1), bienestarSystem.getStudents().get(0).getNutritionalStates().get(0).getDate());
    }

    /**
     * The testModifyNutritionalAtApril function tests the modification of a student's nutritional
     * state at a specific date.
     */
    @Test
    public void testModifyNutritionalAtApril() {
        setUpWithNutritionalStates();
        String id = "A00000001";
        assertEquals(bienestarSystem.modifyNutritionalStudent(id, 58.0, 1.70, new GregorianCalendar(2023, Calendar.APRIL, 1)),"Nutritional state modified successfully.");
        assertEquals(58.0, bienestarSystem.getStudents().get(0).getNutritionalStates().get(1).getWeight(), 0.0);
        assertEquals(1.70, bienestarSystem.getStudents().get(0).getNutritionalStates().get(1).getHeight(), 0.0);
        assertEquals(new GregorianCalendar(2023, Calendar.APRIL, 1), bienestarSystem.getStudents().get(0).getNutritionalStates().get(1).getDate());

    }

    /**
     * The function tests if the histogram generated by the bienestarSystem is saved correctly to a
     * text file.
     */
    @Test
    public void saveCorrectlyHistogram(){
        setUpWithNutritionalStates();
        String histogram=bienestarSystem.histogramGenerator();
        bienestarSystem.saveStudentsTxt("/dataTest/histogramControlData.txt", histogram);
        File projectDir = new File(System.getProperty("user.dir"));
        File file = new File(projectDir+"/data/dataTest/histogramControlData.txt");
        assertTrue(file.exists());
    }

/**
 * The function tests if a list report is saved correctly to a text file.
 */

    @Test
    public void saveCorrectlyListReport(){
        setUpWithNutritionalStates();
        String listReport=bienestarSystem.statesListReports(1);
        bienestarSystem.saveStudentsTxt("/dataTest/listReportControlData.txt",listReport);
        File projectDir = new File(System.getProperty("user.dir"));
        File file = new File(projectDir+"/data/dataTest/listReportControlData.txt");
        assertTrue(file.exists());
    }
   

/**
 * The function tests if a file is saved correctly with the indicator change data.
 */

    @Test
    public void saveCorrectlyIndicatorChange(){
        setUpWithNutritionalStates();
        String indicatorChange=bienestarSystem.indicatorChangesNutritionalStates();
        bienestarSystem.saveStudentsTxt("/dataTest/indicatorChangeControlData.txt",indicatorChange);
        File projectDir = new File(System.getProperty("user.dir"));
        File file = new File(projectDir+"/data/dataTest/indicatorChangeControlData.txt");
        assertTrue(file.exists());
    }

    /**
     * The function tests if the indicator list change for nutritional states is saved correctly to a
     * text file.
     */
    @Test
    public void saveCorrectlyIndicatorListChange(){
        setUpWithNutritionalStates();
        String indicatorChange=bienestarSystem.indicatorListChangeNutritionalStates(1);
        bienestarSystem.saveStudentsTxt("/dataTest/indicatorListChangeNutritionalStates.txt",indicatorChange);
        File projectDir = new File(System.getProperty("user.dir"));
        File file = new File(projectDir+"/data/dataTest/indicatorListChangeNutritionalStates.txt");
        assertTrue(file.exists());
    }
}