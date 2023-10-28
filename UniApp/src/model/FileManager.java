package model;

import java.io.*;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;
import exceptions.ExceptionFormatFileNotAllowed;

/**
 * The FileManager class is used for managing files in Java.
 */
public class FileManager {

    private static FileManager instance;
    private File dataFolder;
    private File reports;
    private File jsonFile;

    // The `private FileManager()` constructor is initializing the `FileManager` object by setting the
    // paths for the data folder, reports folder, and JSON file.
    private FileManager() {
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir + "/data");
        reports = new File(dataFolder + "/reports");
        jsonFile = new File(dataFolder + "/studentsData.json");
    }

   /**
    * The getInstance() function returns the instance of the FileManager class, creating it if it
    * doesn't already exist.
    * 
    * @return The `getInstance()` method is returning an instance of the `FileManager` class.
    */
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * The function creates necessary directories and files if they do not already exist.
     */
    public void createResources() throws IOException {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
            if (!reports.exists()) {
                reports.mkdirs();
            }
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }
        }
    }

    /**
     * The function saves a list of students to a JSON file.
     * 
     * @param students An ArrayList of Student objects that contains the students to be saved.
     * @param path The path parameter is a string that represents the file path where the students'
     * data will be saved.
     * @return The method is returning a string message stating that the students were saved
     * successfully.
     */
    public String saveStudents(ArrayList<Student> students, String path)
            throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".json")) {
            throw new ExceptionFormatFileNotAllowed("JSON");
        }
        jsonFile = new File(dataFolder + path);
        createResources();
        Gson gson = new Gson();
        FileOutputStream fos = new FileOutputStream(jsonFile);
        String json = gson.toJson(students);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(json);
        writer.flush();
        writer.close();

        return "The students were saved successfully\n\n";
    }

   /**
    * The function loads student data from a JSON file and returns an ArrayList of Student objects.
    * 
    * @param path The path parameter is a string that represents the file path of the JSON file
    * containing student data.
    * @return The method is returning an ArrayList of Student objects.
    */
    public ArrayList<Student> loadStudent(String path) throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".json")) {
            throw new ExceptionFormatFileNotAllowed("JSON");
        }
        jsonFile = new File(dataFolder + path);
        createResources();
        ArrayList<Student> students = new ArrayList<>();
        String content = "";
        String line = "";
        Gson gson = new Gson();
        FileInputStream fis = new FileInputStream(jsonFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        reader.close();
        Student[] student = gson.fromJson(content, Student[].class);
        // students=gson.fromJson(content, students.getClass());
        students.addAll(Arrays.asList(student));
        return students;
    }

    
    /**
     * The function saves a given string of information to a text file at the specified path.
     * 
     * @param path The path parameter is a string that represents the file path where the TXT file will
     * be saved.
     * @param information The "information" parameter is a string that contains the data that you want
     * to save in the TXT file.
     * @return The method is returning a string message "The report was saved successfully\n\n".
     */
    public String saveFileTXT(String path, String information) throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".txt")) {
            throw new ExceptionFormatFileNotAllowed("TXT");
        }
        reports = new File(dataFolder + path);
        createResources();

        FileOutputStream save = new FileOutputStream(reports);
        String data = information;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(save));
        writer.write(data); // IOException
        writer.newLine();
        writer.flush();
        writer.close();
        return "The report was saved successfully\n\n";
    }

    /**
     * The function loads the content of a text file given its path and returns it as a string.
     * 
     * @param path The path parameter is a string that represents the file path of the TXT file that
     * needs to be loaded.
     * @return The method is returning the content of the file as a String.
     */
    public String loadFileTXT(String path) throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".txt")) {
            throw new ExceptionFormatFileNotAllowed("TXT");
        }
        reports = new File(dataFolder + path);
        createResources();
        FileInputStream fis = new FileInputStream(reports);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String content = "";

        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        reader.close();
        return content;
    }

    /**
     * The function `loadCSV` reads a CSV file containing student data, parses the data, and returns an
     * ArrayList of Student objects.
     * 
     * @param path The path parameter is a String that represents the file path of the CSV file that
     * needs to be loaded.
     * @return The method is returning an ArrayList of Student objects.
     */
    public ArrayList<Student> loadCSV(String path) throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".csv")) {
            throw new ExceptionFormatFileNotAllowed("CSV");
        }
        reports = new File(dataFolder + path);
        createResources();
        FileInputStream fis = new FileInputStream(reports);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String line = reader.readLine();
        String[] parts = line.split(",");

        String content = "";
        ArrayList<Student> students = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            content = line;
            parts = content.split(",");
            if (parts.length == 1)
                parts = content.split(";");

            if (parts.length < 8 || parts.length > 13) {
                throw new ExceptionFormatFileNotAllowed("CSV");
            }
            String name = parts[0];
            String lastName = parts[1];
            int years = Integer.parseInt(parts[2]);
            String id = parts[3];
            Sex sex = null;
            if (parts[4].equals("M")) {
                sex = Sex.M;
            } else if (parts[4].equals("F")) {
                sex = Sex.F;
            }
            if (parts[4].equals("O")) {
                sex = Sex.O;
            }
            Double weightS = Double.parseDouble(parts[5]);
            Double weightA = Double.parseDouble(parts[6]);
            Double height = Double.parseDouble(parts[7]);
            NutritionalStates nutritionaS = new NutritionalStates(weightS, height,
                    new GregorianCalendar(2022, Calendar.SEPTEMBER, 1));
            NutritionalStates nutritionA = new NutritionalStates(weightA, height,
                    new GregorianCalendar(2023, Calendar.APRIL, 1));
            Student student = new Student(id, years, name, lastName, sex);
            student.addNutritionalState(nutritionaS);
            student.addNutritionalState(nutritionA);
            students.add(student);
        }
        reader.close();
        return students;
    }

   /**
    * The function saves a list of students to a CSV file.
    * 
    * @param students An ArrayList of Student objects, which contains the student data to be saved in
    * the CSV file.
    * @param path The path parameter is a string that represents the file path where the CSV file will
    * be saved.
    * @return The method is returning a string message stating that the report was saved successfully.
    */
    public String saveCSV(ArrayList<Student> students, String path) throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".csv")) {
            throw new ExceptionFormatFileNotAllowed("CSV");

        }
        reports = new File(dataFolder + path);
        createResources();
        FileOutputStream fos = new FileOutputStream(reports);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write("Name;LastName;Years;ID;Sex;Weight (Sep);Weight (Apri);Height; BIM (Sep);BIM(Apr)"); // IOExceptione;lastName;years;id;sex;weight();weightA;height;date");
                                                                                                          // //
                                                                                                          // IOException
        writer.newLine();
        for (Student student : students) {
            writer.write(student.toCSV());
            writer.newLine();
        }
        writer.flush();
        writer.close();
        return "The report was saved successfully\n\n";
    }

}