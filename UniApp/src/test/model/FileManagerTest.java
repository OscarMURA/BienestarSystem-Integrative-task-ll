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

    public void setUp() throws IOException {
        fileManager = FileManager.getInstance();
        ArrayList<Student> students = setUpStudent();
        try {
            fileManager.saveStudents(students, "/dataTest/studentsTest.json");
        } catch (ExceptionFormatFileNotAllowed e) {
            fail();
        }
    }

    public void setUpIntence() {
        fileManager = FileManager.getInstance();
    }

    @Test
    public void testGetInstance() {
        FileManager instance1 = FileManager.getInstance();
        FileManager instance2 = FileManager.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testSingletonInstance() {
        FileManager anotherFileManager = FileManager.getInstance();
        assertSame(FileManager.getInstance(), anotherFileManager);
    }

    @Test
    public void testCreateResources() {
        try {
            setUp();
        } catch (IOException e) {
            fail("IOException thrown when creating resources");
        }
    }

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
