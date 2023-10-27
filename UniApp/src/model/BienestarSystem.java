package model;

import java.util.*;

import Sorting.Collection;
import java.io.IOException;

import exceptions.ExceptionForArrayListUnordered;
import exceptions.ExceptionFormatFileNotAllowed;
import exceptions.ExceptionFormatOfValueNotAllowed;

public class BienestarSystem {

    public ArrayList<Student> students;
    public FileManager fileManager;
    private Reports reports;

    public BienestarSystem() {
        fileManager = FileManager.getInstance();
        students = new ArrayList<Student>();
    }

    public void loadStudents() {
        try {
            students = fileManager.loadStudent("/resources/studentsData.json");
            System.out.println("Datos de estudiantes cargados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al cargar los estudiantes desde el archivo JSON.");
        } catch (exceptions.ExceptionFormatFileNotAllowed e) {
            System.err.println("Error al cargar los estudiantes desde el archivo JSON. por el formato");
        }

    }

    public String addNutritionalStateToStudent(String id, NutritionalStates nutritionalState) {
        String msj = "";
        Student student = binarySearch(students, id);
        if (student != null) {
            student.addNutritionalState(nutritionalState);
            msj = "Estado nutricional añadido correctamente";
        } else {
            msj = "No se encontro el estudiante con id: " + student.getId();
        }
        return msj;
    }

    public void saveStudents() {
        try {
            fileManager.saveStudents(students, "/resources/studentsData.json");

            System.out.println("Datos de estudiantes guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los estudiantes en el archivo JSON.");
        } catch (ExceptionFormatFileNotAllowed e) {
            System.err.println("Error al cargar los estudiantes desde el archivo JSON. por el formato");
        }
    }

    public String addStudents(String id, int years, String name, String lastName, Sex sex) {
        Student student = new Student(id, years, name, lastName, sex);
        Collection<Student, Student> collection = new Collection<>();
        Comparator<Student> comparator = Comparator.comparing(Student::getId);
        try {
            collection.binaryInsert(students, comparator, student);
            return "Estudiante añadido exitosamente.";
        } catch (ExceptionForArrayListUnordered e) {
            return "La lista de estudiantes no está ordenada.";
        }
    }

    /**
     *
     * @param id
     */
    public String removedStudent(String id) {
        Student studentToRemove = binarySearch(students, id);

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            return "Student removed successfully.";
        } else {
            return "Student not found.";
        }
    }

    /**
     * @param id
     */
    public boolean searchStudent(String id) {
        return binarySearch(students, id) != null;
    }

    public String modifyStudent(String id, int years, String name, String lastName, Sex sex) {
        String msg = "";
        Student student = binarySearch(students, id);

        if (student != null) {
            if (years != 0) {
                student.setYears(years);
                msg += "\nAño modificado.";
            }
            if (name!=null) {
                student.setName(name);
                msg += "\nNombre modificado.";
            }

            if (lastName!=null) {
                student.setLastName(lastName);
                msg += "\nLast name modificado.";
            }

            if(sex !=null){
                student.setSex(sex);
                msg+="\nSex modificado";
            }

            if (!msg.isEmpty()) {
                msg = "Atributos modificados exitosamente:" + msg;
            }
        } else {
            msg = "La tarea con el ID " + id + " no existe.";
        }

        return msg + "\n";
    }

    public Sex validateSex(String newSexInput){
        Sex newSex = null;
        String msj="";
        if (!newSexInput.isBlank()) {
            if (newSexInput.equalsIgnoreCase("M")) {
                newSex = Sex.M;
            } else if (newSexInput.equalsIgnoreCase("F")) {
                newSex = Sex.F;
            } else if (newSexInput.equalsIgnoreCase("O")) {
                newSex = Sex.O;
            } else {
                msj = "Invalid sex input. Please enter M, F, or O.";
            }
        }
        return newSex;
    }

    public String modifyNutritionalStudent(String id, double weight, double height, Calendar date) {
        String msj = "";
        Student student = binarySearch(students, id);
        if (student != null) {
            NutritionalStates nutritionalStateToModify = findNutritionalStateToModify(student, date);
            if (nutritionalStateToModify != null) {
                nutritionalStateToModify.setWeight(weight);
                nutritionalStateToModify.setHeight(height);
                msj= "Nutritional state modified successfully.";
            } else {
                msj = "Nutritional state for the specified date not found.";
            }
        }
        return msj;
    }

    public NutritionalStates findNutritionalStateToModify(Student student, Calendar date) {
        for (NutritionalStates nutritionalState : student.getNutritionalStates()) {
            if (nutritionalState.getDate().equals(date)) {
                return nutritionalState;
            }
        }
        return null;
    }
    

    public String histogramGenerator() {
        String msj = "";

        try {
            msj = reports.histogramGenerator();

        } catch (ExceptionFormatOfValueNotAllowed e) {
            msj = "Error: " + e.getMessage() + "\n\n";
        }
        return msj;
    }

    public String statesIndicatorReports() {
        String msj = "";

        try {
            msj = reports.statesIndicatorReports();

        } catch (ExceptionFormatOfValueNotAllowed e) {
            msj = "Error: " + e.getMessage() + "\n\n";
        }
        return msj;
    }

    /*
     * public String listIndicatorReport(int typeOrden) {
     * 
     * }
     */

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudentsList(ArrayList<Student> students) {
        this.students = students;
    }

    public Student binarySearch(ArrayList<Student> students, String searchId) {
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student student = students.get(mid);
            int comparison = student.getId().compareTo(searchId);

            if (comparison == 0) {
                return student;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public String listStudents() {
        String msj = "";
        for (Student student : students) {
            msj += student.toString() + "\n";
        }
        return msj;
    }
}
