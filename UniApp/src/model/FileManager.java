package model;

import java.io.*;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;
import exceptions.ExceptionFormatFileNotAllowed;

public class FileManager {

    private static FileManager instance;
    private File dataFolder;
    private File reports;
    private File jsonFile;

    private FileManager() {
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir + "/data");
        reports = new File(dataFolder + "/reports");
        jsonFile = new File(dataFolder + "/studentsData.json");
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
            if (!reports.exists()) {
                reports.mkdirs();
            }
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }
        }
    }

    /**
     *
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
     *
     * @param path
     * @param information
     */
    public String saveFileTXT(String path, String information) throws IOException, ExceptionFormatFileNotAllowed {
        if (!path.endsWith(".txt")) {
            throw new ExceptionFormatFileNotAllowed("TXT");
        }
        reports = new File(dataFolder + path);
        System.out.println("entre al save");
        createResources();
        System.out.println("entre al save");
        
        FileOutputStream save = new FileOutputStream(reports);
        String data = information;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(save));
        writer.write(data); // IOException
        writer.flush();
        writer.close();
        return "The report was saved successfully\n\n";
    }

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