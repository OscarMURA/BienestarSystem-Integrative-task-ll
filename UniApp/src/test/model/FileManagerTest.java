package test.model;

import exceptions.ExceptionFormatFileNotAllowed;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Student;
import model.NutritionalStates;
import static org.junit.Assert.*;
import model.FileManager;
import model.Sex;

public class FileManagerTest {
    private FileManager fileManager;
    public ArrayList<Student> setUpStudent() {
        fileManager = FileManager.getInstance();
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("A00391232", 15, "Manuel", "Serrano", Sex.M));
        students.add(new Student("A00391233", 15, "Maria", "Perez", Sex.F));
        NutritionalStates nutritionalStates = new NutritionalStates(100, 1.5, new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        NutritionalStates nutritionalStates2 = new NutritionalStates(90, 1.5, new GregorianCalendar(2023, Calendar.APRIL, 1));
        students.get(0).addNutritionalState(nutritionalStates);
        students.get(0).addNutritionalState(nutritionalStates2);
        NutritionalStates nutritionalStates3 = new NutritionalStates(80, 1.7, new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
        NutritionalStates nutritionalStates4 = new NutritionalStates(80, 1.7, new GregorianCalendar(2023, Calendar.APRIL, 1));
        students.get(1).addNutritionalState(nutritionalStates3);
        students.get(1).addNutritionalState(nutritionalStates4);
        return students;
    }



    /**
     * This test scenario creates the necessary resources for testing.
     */
    public void setUpIntence() {
        fileManager = FileManager.getInstance();
    }

    /**
     * This test tests that the getInstance method of the FileManager class
     * returns the same instance of the FileManager class
     * by using the singleton method
     */
    @Test
    public void testGetInstance() {
        setUpIntence();
        FileManager instance1 = FileManager.getInstance();
        assertSame(instance1, fileManager);
    }



    /**
     * This test scenario tests that the createResources method of the FileManager class
     * creates the necessary resources for testing
     */
    @Test
    public void testCreateResources() {
        setUpIntence();
        try {
            ArrayList<Student> students = setUpStudent();
            try {
                fileManager.saveStudents(students, "/dataTest/studentsTest.json");
            } catch (ExceptionFormatFileNotAllowed e) {
                fail();
            }
        } catch (IOException e) {
            fail("IOException thrown when creating resources");
        }
    }

    /**
     * The system reports the exception ExceptionFormatFileNotAllowed,
     * because the type of file that was tried to save the student dat
     * a is not valid.
     */
    @Test
    public void testCreateResourcesWithException() {
        setUpIntence();
        try {
            ArrayList<Student> students = setUpStudent();
            try {
                fileManager.saveStudents(students, "/dataTest/studentsJSON.txt");
            } catch (ExceptionFormatFileNotAllowed e) {
                assertNotNull(e.getMessage());

            }
        } catch (IOException e) {
            fail();
        }
    }


    /**
     * This test scenario tests that the saveStudents method of the FileManager class
     * saves the students in a json file
     */
    @Test
    public void testLoadStudent() {
        ArrayList<Student> students = null;
        students = setUpStudent();
        ArrayList<Student> loadedStudents = null;
        try {
            loadedStudents = fileManager.loadStudent("/dataTest/studentsTest.json");
        } catch (IOException e) {
            fail("IOException thrown when loading students");
        } catch (ExceptionFormatFileNotAllowed e) {
            fail();
        }
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).toString(), loadedStudents.get(i).toString());
        }
    }

    /**
     * This method tests that the loadStudent method of the FileManager class
     * throws an exception of type ExceptionFormatFileNotAllowed when an attempt is made to load a file
     * that does not have the extension .json
     */
    @Test
    public void testLoadStudentWithException(){
        setUpIntence();
        try {
            fileManager.loadStudent("/dataTest/studentsTest.csv");
            fail();
        } catch (IOException e) {
            fail();
        } catch (ExceptionFormatFileNotAllowed e) {
            assertNotNull(e.getMessage());
        }
    }

    /**
     * This method tests the saving of student data in a csv file to see if it is saved correctly and the resources are created correctly.
     * to see if it is saved correctly and the resources are created correctly.
     */
    @Test
    public void testSaveCSV() {
        ArrayList<Student> students = setUpStudent();
        try {
            fileManager.saveCSV(students, "/dataTest/studentsTest.csv");
        } catch (IOException e) {
            fail("IOException thrown when saving students");
        } catch (ExceptionFormatFileNotAllowed e) {
            fail();
        }
    }


    /**
     * This method tests that the exception of type ExceptionFormatFileNotAllowed is thrown when trying to save a file that does not have extension .csv
     * is thrown when trying to save a file that does not have the .csv extension.
     */
    @Test
    public void testSaveCSVWithException() {
        ArrayList<Student> students = setUpStudent();
        try {
            fileManager.saveCSV(students, "/dataTest/studentsTest.json");
            fail();
        } catch (IOException e) {
            fail();
        } catch (ExceptionFormatFileNotAllowed e) {
            assertNotNull(e.getMessage());
        }
    }


    /**
     * This method tests that the loadCSV method of the FileManager class
     * loads the students from a csv file
     */
    @Test
    public void testLoadCSV() {
        ArrayList<Student> students = setUpStudent();
        ArrayList<Student> loadedStudents = null;
        try {
            loadedStudents = fileManager.loadCSV("/dataTest/studentsTest.csv");
        } catch (IOException e) {
            fail("IOException thrown when loading students");
        } catch (ExceptionFormatFileNotAllowed e) {
            fail();
        }
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).toString(), loadedStudents.get(i).toString());
        }
    }

    /**
     * This method tests that the exception of type ExceptionFormatFileNotAllowed is thrown when trying to load a file that does not have extension .csv
     * is thrown when trying to load a file that does not have the .csv extension.
     */
    @Test
    public void testLoadCSVWithException() {
        setUpIntence();
        try {
            fileManager.loadCSV("/dataTest/studentsTest.json");
            fail();
        } catch (IOException e) {
            fail();
        } catch (ExceptionFormatFileNotAllowed e) {
            assertTrue(true);
        }
    }

    /**
     * This method tests that the saveFileTXT method of the FileManager class
     * saves the information in a txt file
     */
    @Test
    public void testSaveFileTXT() {
        setUpIntence();
        String message = "This is a test";
        try {
            fileManager.saveFileTXT("/dataTest/test.txt", message);
        } catch (IOException e) {
            fail("IOException thrown when saving file");
        } catch (ExceptionFormatFileNotAllowed e) {
            fail();
        }
    }

    /**
     * This method tests that the exception of type ExceptionFormatFileNotAllowed is
     * thrown when trying to save a file that does not have extension .txt
     */
    @Test
    public void testSaveFileTXTWithException() {
        setUpIntence();
        String message = "This is a test";
        try {
            fileManager.saveFileTXT("/dataTest/test.json", message);
            fail();
        } catch (IOException e) {
            fail();
        } catch (ExceptionFormatFileNotAllowed e) {
            assertNotNull(e.getMessage());

        }
    }

    /**
     * This method tests that the loadFileTXT method of the FileManager class
     * loads the information from a txt file
     */
    @Test
    public void testLoadFileTXT() {
        setUpIntence();
        String message = "This is a test\n";
        String loadedMessage = null;
        try {
            loadedMessage = fileManager.loadFileTXT("/dataTest/test.txt");
        } catch (IOException e) {
            fail("IOException thrown when loading file");
        } catch (ExceptionFormatFileNotAllowed e) {
            fail();
        }
        assertEquals(message, loadedMessage);
    }

    /**
     * This method tests that the exception of type ExceptionFormatFileNotAllowed is
     * thrown when trying to load a file that does not have extension .txt
     */
    @Test
    public void testLoadFileTXTWithException() {
        setUpIntence();
        try {
            fileManager.loadFileTXT("/dataTest/test.json");
            fail();
        } catch (IOException e) {
            fail();
        } catch (ExceptionFormatFileNotAllowed e) {
            assertNotNull(e.getMessage());
        }
    }

}
