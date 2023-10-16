package test.model;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;
import model.FileManager;

public class FileManagerTest {

    private FileManager fileManager;
    private File testFolder;

    @Before
    public void setUp() {
        fileManager = FileManager.getInstance();
        testFolder = new File("test_folder");
        fileManager.dataFolder = new File(testFolder, "data");
        fileManager.reports = new File(fileManager.dataFolder, "reports");
        fileManager.jsonFile = new File(fileManager.dataFolder, "students.json");
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
        assertEquals(fileManager, anotherFileManager);
    }

    @Test
    public void testCreateResources() {

    }

    @Test
    public void testLoadStudent() {

    }

    @Test
    public void testSaveReports() {

    }

}