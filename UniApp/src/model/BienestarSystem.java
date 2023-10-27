package model;

import java.util.*;

import Sorting.Collection;
import java.io.IOException;

import exceptions.ExceptionForArrayListUnordered;
import exceptions.ExceptionFormatFileNotAllowed;
import exceptions.ExceptionFormatOfValueNotAllowed;

public class BienestarSystem {

    private ArrayList<Student> students;
    private FileManager fileManager;
    private Reports reports;

    public BienestarSystem() {
        fileManager = FileManager.getInstance();
        students = new ArrayList<Student>();

        String title = "Illustration of quantitative data of nutritional statuses ";
        String[] categories = { "low weight", "normal", "overweight", "obesity", "morbid obesity" };
        ArrayList<Object> values = new ArrayList<>();
        reports = new Reports(title, new ArrayList<>(Arrays.asList(categories)), values);
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
            if (name != null) {
                student.setName(name);
                msg += "\nNombre modificado.";
            }

            if (lastName != null) {
                student.setLastName(lastName);
                msg += "\nLast name modificado.";
            }

            if (sex != null) {
                student.setSex(sex);
                msg += "\nSex modificado";
            }

            if (!msg.isEmpty()) {
                msg = "Atributos modificados exitosamente:" + msg;
            }
        } else {
            msg = "La tarea con el ID " + id + " no existe.";
        }

        return msg + "\n";
    }

    public Sex validateSex(String newSexInput) {
        Sex newSex = null;
        String msj = "";
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

    public String modifyNutritionalStudent(String id, Double weight, Double height, Calendar date) {
        String msj = "";
        Student student = binarySearch(students, id);
        if (student != null) {
            NutritionalStates nutritionalStateToModify = findNutritionalStateToModify(student, date);
            if (nutritionalStateToModify != null) {
                if (weight != 0.0) {
                    nutritionalStateToModify.setWeight(weight);
                }
                if (height != 0.0) {
                    nutritionalStateToModify.setHeight(height);
                }
                msj = "Nutritional state modified successfully.";
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
        String msj = "", histogram = "";
        int i = 0;
        String[] categories = { "low weight", "normal", "overweight", "obesity", "morbid obesity" };
        String[] title = { "Histogram_of_the_BMI_of_students_in_September_2022",
                "Histogram_of_the_BMI_of_students_in_April_2023" };
        do {
            ArrayList<Integer> values = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
            ArrayList<Object> objects = new ArrayList<>();
            for (Student student : students) {
                TypeStates type = student.getNutritionalStates().get(i).getType();
                if (type.equals(TypeStates.LOW_WEIGHT))
                    values.set(0, values.get(0) + 1);
                else if (type.equals(TypeStates.NORMAL_WEIGHT))
                    values.set(1, values.get(1) + 1);
                else if (type.equals(TypeStates.OVERWEIGHT))
                    values.set(2, values.get(2) + 1);
                else if (type.equals(TypeStates.OBESITY))
                    values.set(3, values.get(3) + 1);
                else if (type.equals(TypeStates.MORBID_OBESITY))
                    values.set(4, values.get(4) + 1);
            }
            objects.addAll(values);
            reports = new Reports(title[i], new ArrayList<>(Arrays.asList(categories)), objects);
            try {
                histogram += reports.histogramGenerator() + "\n\n";
            } catch (ExceptionFormatOfValueNotAllowed e) {
                msj = "Error: " + e.getMessage() + "\n\n";
            }
            i++;
        } while (i < 2);
        return histogram;
    }

    public String statesListReports(int option) {
        String msj = "";
        Comparator<Student> comparator = null;
        Comparator<Student> comparator2 = null;
        String[] title = { "List_of_the_BMI_of_students_in_September_2022",
                "List_of_the_BMI_of_students_in_April_2023" };
        String[] categories = { "low weight", "normal", "overweight", "obesity", "morbid obesity" };

        if (option == 1) {
            comparator = (student1, student2) -> Double.compare(student1.getNutritionalStates().get(0).getBMI(),
                    student2.getNutritionalStates().get(0).getBMI());
            comparator2 = (student1, student2) -> Double.compare(student1.getNutritionalStates().get(1).getBMI(),
                    student2.getNutritionalStates().get(1).getBMI());
        } else if (option == 2)
            comparator = Comparator.comparing(Student::getYears);
        else if (option == 3)
            comparator = (student1, student2) -> student1.compare(student1, student2);
        ArrayList<Student> studentsSorted = new ArrayList<>(students);
        Collection<Student, Student> collection = new Collection();
        collection.Sort(studentsSorted, comparator);
        int i = 0;
        do {
            if (option == 1 && i == 1) {
                collection.Sort(studentsSorted, comparator2);
            }
            String lowWeight = "", normalWeight = "", overweight = "", obesity = "", morbidObesity = "";

            for (Student student : studentsSorted) {
                TypeStates type = student.getNutritionalStates().get(i).getType();
                if (type.equals(TypeStates.LOW_WEIGHT)) {
                    lowWeight += "\t" + student.formatList(i) + "\n";
                } else if (type.equals(TypeStates.NORMAL_WEIGHT))
                    normalWeight += "\t" + student.formatList(i) + "\n";
                else if (type.equals(TypeStates.OVERWEIGHT))
                    overweight += "\t" + student.formatList(i) + "\n";
                else if (type.equals(TypeStates.OBESITY))
                    obesity += "\t" + student.formatList(i) + "\n";
                else if (type.equals(TypeStates.MORBID_OBESITY))
                    morbidObesity += "\t" + student.formatList(i) + "\n";
            }
            ArrayList<Object> values = new ArrayList<>(
                    Arrays.asList(lowWeight, normalWeight, overweight, obesity, morbidObesity));
            reports = new Reports(title[i], new ArrayList<>(Arrays.asList(categories)), values);
            try {
                msj += reports.listIndicatorReports();
            } catch (ExceptionFormatOfValueNotAllowed e) {
                msj = "Error: " + e.getMessage() + "\n\n";
            }
            i++;
        } while (i < 2);
        return msj;
    }

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

    public String indicatorChangesNutritionalStates() {
        String out = "";
        int lowToNormal = 0, overweightToNormal = 0, obesityToNormal = 0, morbidObesityToNormal = 0;
        int normalToLow = 0, normalToOverwieght = 0, overweightToMore = 0, obesityToMorbid = 0;
        int allChange = 0, plus = 0, less = 0;

        for (Student student : students) {
            TypeStates type = student.getNutritionalStates().get(0).getType();
            TypeStates type2 = student.getNutritionalStates().get(1).getType();

            if (type.equals(TypeStates.LOW_WEIGHT) && type2.equals(TypeStates.NORMAL_WEIGHT))
                lowToNormal++;
            else if (type.equals(TypeStates.OVERWEIGHT) && type2.equals(TypeStates.NORMAL_WEIGHT))
                overweightToNormal++;
            else if (type.equals(TypeStates.OBESITY)
                    && (type2.equals(TypeStates.NORMAL_WEIGHT) || type2.equals(TypeStates.OVERWEIGHT)))
                obesityToNormal++;
            else if (type.equals(TypeStates.MORBID_OBESITY)
                    && (type2.equals(TypeStates.NORMAL_WEIGHT) || type2.equals(TypeStates.OVERWEIGHT)))
                morbidObesityToNormal++;
            else if (type.equals(TypeStates.NORMAL_WEIGHT) && type2.equals(TypeStates.LOW_WEIGHT))
                normalToLow++;
            else if (type.equals(TypeStates.NORMAL_WEIGHT)
                    && (type2.equals(TypeStates.OVERWEIGHT) || (type2.equals(TypeStates.OBESITY))))
                normalToOverwieght++;
            else if (type.equals(TypeStates.OVERWEIGHT)
                    && ((type2.equals(TypeStates.OBESITY)) || type2.equals(TypeStates.MORBID_OBESITY)))
                overweightToMore++;
            else if (type.equals(TypeStates.OBESITY) && type2.equals(TypeStates.MORBID_OBESITY))
                obesityToMorbid++;

        }
        allChange = lowToNormal + overweightToNormal + obesityToNormal + morbidObesityToNormal + normalToLow
                + normalToOverwieght + overweightToMore + obesityToMorbid;
        plus = lowToNormal + overweightToNormal + obesityToNormal + morbidObesityToNormal;
        less = normalToLow + normalToOverwieght + overweightToMore + obesityToMorbid;

        ArrayList<Object> values = new ArrayList<>(Arrays.asList(lowToNormal, overweightToNormal, obesityToNormal,
                morbidObesityToNormal, normalToLow, normalToOverwieght, overweightToMore, obesityToMorbid));
        String titleAndSubtitle = "Changes in nutritional status";
        titleAndSubtitle += "\n============================================\n";
        titleAndSubtitle += "Total changes of students: " + allChange;
        ArrayList<String> categories = new ArrayList<>();
        loadCategories(categories, plus, less);
        reports = new Reports(titleAndSubtitle, categories, values);
        try {
            out = reports.statesIndicatorReports();
        } catch (ExceptionFormatOfValueNotAllowed e) {
            out = "Error: " + e.getMessage() + "\n\n";
        }
        return out;

    }

    public String indicatorListChangeNutritionalStates(int option) {
        String out = "";
        String lowToNormal = "", overweightToNormal = "", obesityToNormal = "", morbidObesityToNormal = "";
        String normalToLow = "", normalToOverwieght = "", overweightToMore = "", obesityToMorbid = "";
        Comparator<Student> comparator = null;
        int allChange = 0, plus = 0, less = 0;
        if (option == 1) {
            comparator = (student1, student2) -> Double.compare(student1.getNutritionalStates().get(1).getBMI(),
                    student2.getNutritionalStates().get(1).getBMI());
        } else if (option == 2)
            comparator = (student1, student2) -> Integer.compare(student1.getYears(), student2.getYears());
        else if (option == 3)
            comparator = (student1, student2) -> student1.compare(student1, student2);
        ArrayList<Student> studentsSorted = new ArrayList<>(students);
        Collection<Student, Student> collection = new Collection();
        collection.Sort(studentsSorted, comparator);
        for (Student student : students) {
            TypeStates type = student.getNutritionalStates().get(0).getType();
            TypeStates type2 = student.getNutritionalStates().get(1).getType();
            if (type.equals(TypeStates.LOW_WEIGHT) && type2.equals(TypeStates.NORMAL_WEIGHT)) {
                lowToNormal += "\t" + student.indicatorList() + "\n";
                plus++;
            } else if (type.equals(TypeStates.NORMAL_WEIGHT) && type2.equals(TypeStates.LOW_WEIGHT)) {
                normalToLow += "\t" + student.indicatorList() + "\n";
                less++;
            } else if (type.equals(TypeStates.NORMAL_WEIGHT)
                    && (type2.equals(TypeStates.OVERWEIGHT) || (type2.equals(TypeStates.OBESITY)))) {
                normalToOverwieght += "\t" + student.indicatorList() + "\n";
                less++;
            } else if (type.equals(TypeStates.OVERWEIGHT) && type2.equals(TypeStates.NORMAL_WEIGHT)) {
                overweightToNormal += "\t" + student.indicatorList() + "\n";
                plus++;
            } else if (type.equals(TypeStates.OVERWEIGHT)
                    && ((type2.equals(TypeStates.OBESITY)) || type2.equals(TypeStates.MORBID_OBESITY))) {
                overweightToMore += "\t" + student.indicatorList() + "\n";
                less++;
            } else if (type.equals(TypeStates.OBESITY) && type2.equals(TypeStates.MORBID_OBESITY)) {
                obesityToMorbid += "\t" + student.indicatorList() + "\n";
                less++;
            } else if (type.equals(TypeStates.MORBID_OBESITY)
                    && (type2.equals(TypeStates.NORMAL_WEIGHT) || type2.equals(TypeStates.OVERWEIGHT))) {
                morbidObesityToNormal += "\t" + student.indicatorList() + "\n";
                plus++;
            } else if (type.equals(TypeStates.OBESITY)
                    && (type2.equals(TypeStates.NORMAL_WEIGHT) || type2.equals(TypeStates.OVERWEIGHT))) {
                obesityToNormal += "\t" + student.indicatorList() + "\n";
                plus++;
            }
        }
        allChange = plus + less;
        ArrayList<Object> values = new ArrayList<>(Arrays.asList(lowToNormal, overweightToNormal, obesityToNormal,
                morbidObesityToNormal, normalToLow, normalToOverwieght, overweightToMore, obesityToMorbid));
        String titleAndSubtitle = "Changes in nutritional status";
        titleAndSubtitle += "\n====================================\n";
        titleAndSubtitle += "Total changes of students: " + allChange + "\n";
        ArrayList<String> categories = new ArrayList<>();
        loadCategories(categories, plus, less);
        reports = new Reports(titleAndSubtitle, categories, values);
        try {
            out = reports.listIndicatorReports();
        } catch (ExceptionFormatOfValueNotAllowed e) {
            out = "Error: " + e.getMessage() + "\n\n";
        }
        return out;
    }

    private void loadCategories(ArrayList<String> categories, int plus, int less) {
        categories.add("\nStudents with positive changes " + plus + "\n\t*Change low weight to normal weight: ");
        categories.add(" \t*Change overweight to normal weight: ");
        categories.add(" \t*Change obesity to overweight or normal weight: ");
        categories.add(" \t*Change morbid obesity to normal weight or overweight: ");
        categories.add("Students with negative changes " + less + "\n \t*Change normal weight to low weight: ");
        categories.add(" \t*Change normal weight to overweight or obesity: ");
        categories.add(" \t*Change of overweight to more category: ");
        categories.add(" \t*Change obesity to morbid obesity: ");
    }

}
