package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;


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
     * @param students
     */
    public String saveStudents(ArrayList<Student> students) throws IOException {

        createResources();
        Gson gson = new Gson();

        FileOutputStream fos=new FileOutputStream(jsonFile);
        String json=gson.toJson(students);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(json); // IOException
        writer.flush();
        writer.close();

        return "The students were saved successfully\n\n";
    }

    public ArrayList<Student> loadStudent() throws IOException {
        createResources();
        ArrayList<Student> students = new ArrayList<>();

        String content="";
        String line="";
        Gson gson = new Gson();
        FileInputStream fis=new FileInputStream(jsonFile);
        BufferedReader reader=new BufferedReader(new InputStreamReader(fis));

        while ((line=reader.readLine())!=null){
            content+=line+"\n";
        }
        reader.close();
        students=gson.fromJson(content, students.getClass());
        return students;
    }

    /**
     *
     * @param path
     * @param information
     */
    public String saveReports(String path, String information) throws IOException {
        reports=new File(dataFolder+path);
        createResources();
        FileOutputStream save=new FileOutputStream(reports);
        String data=information;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(save));
        writer.write(data); // IOException
        writer.flush();
        writer.close();

        return "The report was saved successfully\n\n";
    }



    public String loadReports(String path) throws IOException {
        reports=new File(dataFolder+path);
        createResources();
        FileInputStream fis=new FileInputStream(reports);
        BufferedReader reader=new BufferedReader(new InputStreamReader(fis));
        String line="";
        String content="";
        while ((line=reader.readLine())!=null){
            content+=line+"\n";
        }
        reader.close();
        return content;
    }





}