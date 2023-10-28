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

    public String loadStudentsJson() {
        String msj = "";
        try {
            students = fileManager.loadStudent("/resources/studentsData.json");
        } catch (IOException e) {
            msj = "Error al cargar los estudiantes desde el archivo JSON.";
        } catch (exceptions.ExceptionFormatFileNotAllowed e) {
            msj = "Error al cargar los estudiantes desde el archivo JSON. por el formato";
        }
        return msj;

    }

    public String saveStudentsJson() {
        String msj = "";
        try {
            fileManager.saveStudents(students, "/resources/studentsData.json");
        } catch (IOException e) {
            msj = "Error al guardar los estudiantes en el archivo JSON.";
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "Error al cargar los estudiantes desde el archivo JSON. por el formato";
        }
        return msj;
    }

    public String loadStudentsCSV() {
        String msj = "";
        try {
            students = fileManager.loadCSV("/resources/freshman_kgs.csv");
        } catch (IOException e) {
            msj = "Error al cargar los estudiantes desde el archivo CSV.";
        } catch (exceptions.ExceptionFormatFileNotAllowed e) {
            msj = "Error al cargar los estudiantes desde el archivo CSV. por el formato";
        }
        return msj;
    }

    public String saveStudentsCVC() {
        String msj = "";
        try {
            fileManager.saveCSV(students, "/resources/freshman_kgs.csv");
        } catch (IOException e) {
            msj = "Error al guardar los estudiantes en el archivo CSV.";
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "Error al cargar los estudiantes desde el archivo CSV. por el formato";
        }
        return msj;
    }

    public String loadStudentsTxt() {
        String msj = "";
        try {
            msj = fileManager.loadFileTXT("/resources/students.txt");
        } catch (IOException e) {
            msj = "Error al cargar los estudiantes desde el archivo TXT: " + e.getMessage();
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "Error al cargar los estudiantes desde el archivo TXT. Formato de archivo no permitido.";
        }
        return msj;
    }

    public String saveStudentsTxt(String information) {
        String msj = "";
        try {
            msj = fileManager.saveFileTXT("/resources/students.txt", information);
        } catch (IOException e) {
            msj = "Error al guardar los estudiantes en el archivo TXT: " + e.getMessage();
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "Error al guardar los estudiantes en el archivo TXT. Formato de archivo no permitido.";
        }
        return msj;
    }

    public String addNutritionalStateToStudent(String id, double weight, double height, Calendar date) {
        String msj = "";
        NutritionalStates nutritionalState = new NutritionalStates(weight, height, date);
        Student student = binarySearch(students, id);
        if (student != null) {
            student.addNutritionalState(nutritionalState);
            msj = "Estado nutricional añadido correctamente";
        } else {
            msj = "No se encontro el estudiante con id: " + student.getId();
        }
        return msj;
    }

    public String addStudents(String id, int years, String name, String lastName, String newsex) {
        String msj = "";
        Sex sex = Sex.valueOf(newsex);
        Student student = new Student(id, years, name, lastName, sex);
        Collection<Student, Student> collection = new Collection<>();
        Comparator<Student> comparator = Comparator.comparing(Student::getId);
        try {
            collection.binaryInsert(students, comparator, student);
            msj = "Estudiante añadido exitosamente.";
        } catch (ExceptionForArrayListUnordered e) {
            msj = "La lista de estudiantes no está ordenada.";
        }
        return msj;
    }

    /**
     * @param id
     */
    public String removedStudent(String id) {
        String msj = "";
        Student studentToRemove = binarySearch(students, id);

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            msj = "Student removed successfully.";
        } else {
            msj = "Student not found.";
        }
        return msj;
    }

    /**
     * @param id
     */
    public boolean searchStudent(String id) {
        return binarySearch(students, id) != null;
    }

    public String modifyStudent(String id, int years, String name, String lastName, String newSex) {
        String msg = "";
        Sex sex = Sex.valueOf(newSex.toUpperCase());
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

    public String validateSex(String newSexInput) {
        String result = null;
        String newSex = newSexInput.toUpperCase();
        if (newSex.equals("M") || newSex.equals("F") || newSex.equals("O")) {
            result = newSex;
        } else {
            result = null;
        }
        return result;
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
        NutritionalStates state = null;
        int i = 0;
        while (state == null && i < student.getNutritionalStates().size()) {
            NutritionalStates nutritionalState = student.getNutritionalStates().get(i);
            if (nutritionalState.getDate().equals(date)) {
                state = nutritionalState;
            }
            i++;
        }
        return state;
    }

    public String histogramGenerator() {
        String msj = "", histogram = "";
        int i = 0;
        String[] categories = { "low weight", "normal", "overweight", "obesity", "morbid obesity" };
        String[] title = { "Histogram of the BMI of students in September 2022",
                "Histogram of the BMI of students in April 2023" };
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
                histogram += reports.histogramGenerator() + "\n";
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
        String[] title = { "List of the BMI of students in September 2022",
                "List of the BMI of students in April 2023" };
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
            int comparison = student.getId().toUpperCase().compareTo(searchId.toUpperCase());

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
        String titleAndSubtitle = "-------Changes in nutritional status-------";
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
        titleAndSubtitle += "\n=============================================\n";
        titleAndSubtitle += "Total changes of students: " + allChange;
        ArrayList<String> categories = new ArrayList<>();
        loadCategoriesList(categories, plus, less);
        reports = new Reports(titleAndSubtitle, categories, values);
        try {
            out = reports.listIndicatorReports();
        } catch (ExceptionFormatOfValueNotAllowed e) {
            out = "Error: " + e.getMessage() + "\n\n";
        }
        return out;
    }

    private void loadCategories(ArrayList<String> categories, int plus, int less) {
        categories.add("\nStudents with positive changes: " + plus + "\n\n \t- Change low weight to normal weight: ");
        categories.add(" \t- Change overweight to normal weight: ");
        categories.add(" \t- Change obesity to overweight or normal weight: ");
        categories.add(" \t- Change morbid obesity to normal weight or overweight: ");
        categories.add("\nStudents with negative changes: " + less + "\n\n \t- Change normal weight to low weight: ");
        categories.add(" \t- Change normal weight to overweight or obesity: ");
        categories.add(" \t- Change of overweight to more category: ");
        categories.add(" \t- Change obesity to morbid obesity: ");
    }

    private void loadCategoriesList(ArrayList<String> categories, int plus, int less) {
        categories.add("\nStudents with positive changes " + plus + "\n\n Change low weight to normal weight ");
        categories.add(" change overweight to normal weight ");
        categories.add(" change obesity to overweight or normal weight ");
        categories.add(" change morbid obesity to normal weight or overweight ");
        categories.add("\nStudents with negative changes " + less + "\n\n Change normal weight to low weight ");
        categories.add(" change normal weight to overweight or obesity ");
        categories.add(" change of overweight to more category ");
        categories.add(" change obesity to morbid obesity ");
    }

}
