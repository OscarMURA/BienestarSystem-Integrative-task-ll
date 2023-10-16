package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileManager {

    private static FileManager instance;
    public File dataFolder;
    public File reports;
    public File jsonFile;

    private FileManager() {

        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir + "/data");
        reports = new File(dataFolder + "/reports");
        jsonFile = new File(dataFolder + "/students.json");
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void createResources() throws IOException {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        if (!reports.exists()) {
            reports.mkdirs();
        }
    }

    /**
     *
     * @param students
     */
    public String saveStudents(Student[] students) {
        // saveStudents
        throw new UnsupportedOperationException();
    }

    public Student[] loadStudent() {
        // loadStudent
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param path
     * @param information
     */
    public String saveReports(String path, String information) {
        // saveReports
        throw new UnsupportedOperationException();
    }

}