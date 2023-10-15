package model;

import java.io.*   ;
public class FileManager {

    private static FileManager instance;
    private File dataFolder;
    private File reports;
    private File jsonFile;

    private FileManager(){

        File projectDir=new File(System.getProperty("user.dir"));
        dataFolder=new File(projectDir+"/data");
        reports=new File(dataFolder+"/reports");
        jsonFile=new File(dataFolder+"/students.json");
    }

    public static FileManager getInstance(){
        if(instance==null){
            instance=new FileManager();
        }
        return instance;
    }

    private void createResources() {
        // createResources
        throw new UnsupportedOperationException();
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