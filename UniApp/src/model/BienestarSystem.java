package model;

import java.util.*;

import Sorting.Collection;
import java.io.IOException;

import exceptions.ExceptionForArrayListUnordered;
import exceptions.ExceptionFormatFileNotAllowed;
import exceptions.ExceptionFormatOfValueNotAllowed;

/**
 * The BienestarSystem class is a Java class that represents a system for
 * managing well-being.
 */
public class BienestarSystem {

    private ArrayList<Student> students;
    private FileManager fileManager;
    private Reports reports;

    // The above code is defining a constructor for the BienestarSystem class. It
    // initializes the
    // fileManager variable with an instance of the FileManager class, creates an
    // empty ArrayList
    // called students, and sets up a Reports object called reports with a title,
    // categories, and
    // values. The code also includes a comment describing a function that attempts
    // to load student
    // data from a JSON file and returns an error message if there are any issues.
    public BienestarSystem() {
        fileManager = FileManager.getInstance();
        students = new ArrayList<Student>();

        String title = "Illustration of quantitative data of nutritional statuses ";
        String[] categories = { "low weight", "normal", "overweight", "obesity", "morbid obesity" };
        ArrayList<Object> values = new ArrayList<>();
        reports = new Reports(title, new ArrayList<>(Arrays.asList(categories)), values);
    }

    /**
     * The function attempts to load student data from a JSON file and returns an
     * error message if there
     * are any issues.
     * 
     * @return The method is returning a String message.
     */
    public String loadStudentsJson() {
        String msj = "";
        try {
            students = fileManager.loadStudent("/resources/studentsData.json");
        } catch (IOException e) {
            msj = "\nError loading students from JSON file.";
        } catch (exceptions.ExceptionFormatFileNotAllowed e) {
            msj = "\nError loading students from JSON file. because of the format";
        }
        return msj;

    }

    /**
     * The function saves a list of students to a JSON file and returns a message
     * indicating if the
     * operation was successful or if there was an error.
     * 
     * @return The method is returning a String message.
     */
    public String saveStudentsJson() {
        String msj = "";
        try {
            fileManager.saveStudents(students, "/resources/studentsData.json");
        } catch (IOException e) {
            msj = "\nError saving students to JSON file.";
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "\nError loading students from JSON file. because of the format";
        }
        return msj;
    }

    /**
     * The function attempts to load student data from a CSV file and returns an
     * error message if there
     * are any issues.
     * 
     * @return The method is returning a message (msj) indicating whether the
     *         students were
     *         successfully loaded from the CSV file or if there was an error.
     */
    public String loadStudentsCSV() {
        String msj = "";
        try {
            students = fileManager.loadCSV("/resources/freshman_kgs.csv");
        } catch (IOException e) {
            msj = "\nError loading students from CSV file.";
        } catch (exceptions.ExceptionFormatFileNotAllowed e) {
            msj = "\nError loading students from CSV file. because of the format";
        }
        return msj;
    }

    /**
     * The function saves a list of students to a CSV file and returns a message
     * indicating if the
     * operation was successful or if there was an error.
     * 
     * @return The method is returning a String message.
     */
    public String saveStudentsCVC() {
        String msj = "";
        try {
            fileManager.saveCSV(students, "/resources/freshman_kgs.csv");
        } catch (IOException e) {
            msj = "\nError saving students to CSV file.";
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "\nError loading students from CSV file. because of the format";
        }
        return msj;
    }

    /**
     * The function attempts to load student data from a TXT file and returns a
     * message indicating the
     * success or failure of the operation.
     * 
     * @return The method is returning a String message.
     */
    public String loadStudentsTxt() {
        String msj = "";
        try {
            msj = fileManager.loadFileTXT("/resources/students.txt");
        } catch (IOException e) {
            msj = "\nError loading students from TXT file: " + e.getMessage();
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "\nError loading students from TXT file. File format not allowed.";
        }
        return msj;
    }

    /**
     * The function saves student information to a text file and returns a message
     * indicating the
     * success or failure of the operation.
     * 
     * @param information The "information" parameter is a string that contains the
     *                    data of the
     *                    students that you want to save in the "students.txt" file.
     * @return The method is returning a String message.
     */
    public String saveStudentsTxt(String path, String information) {
        String msj = "";
        try {
            msj = fileManager.saveFileTXT(path, information);
        } catch (IOException e) {
            msj = "\nError saving students to TXT file: " + e.getMessage();
        } catch (ExceptionFormatFileNotAllowed e) {
            msj = "\nError saving students to TXT file. File format not allowed.";
        }
        return msj;
    }

    /**
     * The function adds a nutritional state to a student and returns a message
     * indicating whether the
     * operation was successful or not.
     * 
     * @param id     The unique identifier of the student.
     * @param weight The weight of the student in kilograms.
     * @param height The height of the student in meters.
     * @param date   The date parameter is a Calendar object that represents the
     *               date when the nutritional
     *               state is being added to the student.
     * @return The method is returning a String message.
     */
    public String addNutritionalStateToStudent(String id, double weight, double height, Calendar date) {
        String msj = "";
        NutritionalStates nutritionalState = new NutritionalStates(weight, height, date);
        Student student = binarySearch(students, id);
        if (student != null) {
            student.addNutritionalState(nutritionalState);
            msj = "\nNutritional status added correctly";
        } else {
            msj = "\nThe student with ID was not found: " + student.getId();
        }
        return msj;
    }

    /**
     * The function "addStudents" adds a new student to a collection of students,
     * ensuring that the
     * collection is ordered by student ID.
     * 
     * @param id       The ID of the student to be added.
     * @param years    The parameter "years" represents the age or number of years
     *                 of the student.
     * @param name     The name of the student to be added.
     * @param lastName The "lastName" parameter is a String that represents the last
     *                 name of the
     *                 student.
     * @param newsex   The parameter "newsex" is a String that represents the sex of
     *                 the student. It is
     *                 used to create a Sex object using the Sex.valueOf() method.
     * @return The method is returning a String message. The message will be either
     *         "Estudiante añadido
     *         exitosamente." if the student was successfully added to the
     *         collection, or "La lista de
     *         estudiantes no está ordenada." if the collection is not ordered.
     */
    public String addStudents(String id, int years, String name, String lastName, String newsex) {
        String msj = "";
        Sex sex = Sex.valueOf(newsex);
        if (searchStudent(id)) {
            msj = "The id of the student already exist";
            return msj;
        }
        Student student = new Student(id, years, name, lastName, sex);
        Collection<Student, Student> collection = new Collection<>();
        Comparator<Student> comparator = Comparator.comparing(Student::getId);
        try {
            collection.binaryInsert(students, comparator, student);
            msj = "\nStudent added successfully.";
        } catch (ExceptionForArrayListUnordered e) {
            msj = "\nStudent list is not sorted.";
        }
        return msj;
    }

    /**
     * The function removes a student from a list of students based on their ID and
     * returns a message
     * indicating whether the removal was successful or if the student was not
     * found.
     * 
     * @param id The id parameter is a String that represents the unique identifier
     *           of the student to be
     *           removed.
     * @return The method is returning a String message.
     */
    public String removedStudent(String id) {
        String msj = "";
        Student studentToRemove = binarySearch(students, id);

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            msj = "\nStudent removed successfully.";
        } else {
            msj = "\nStudent not found.";
        }
        return msj;
    }

    /**
     * The function searches for a student with a given ID in an array using binary
     * search and returns
     * true if found, false otherwise.
     * 
     * @param id The parameter "id" is a String representing the student ID that we
     *           want to search for
     *           in the "students" array.
     * @return The method is returning a boolean value.
     */
    public boolean searchStudent(String id) {
        return binarySearch(students, id) != null;
    }

    /**
     * The function modifies the attributes of a student object based on the
     * provided parameters and
     * returns a message indicating the modifications made.
     * 
     * @param id       The ID of the student to be modified.
     * @param years    The number of years the student has been studying.
     * @param name     The name parameter is a String that represents the new name
     *                 of the student.
     * @param lastName The "lastName" parameter is a String that represents the last
     *                 name of the
     *                 student.
     * @param newSex   The parameter "newSex" is a String that represents the new
     *                 sex of the student.
     * @return The method is returning a string message indicating the result of
     *         modifying the
     *         student's attributes.
     */
    public String modifyStudent(String id, int years, String name, String lastName, String newSex) {
        String msg = "";
        Student student = binarySearch(students, id);

        if (student != null) {
            if (years != 0) {
                student.setYears(years);
                msg += "\nModified year.";
            }
            if (name != null) {
                student.setName(name);
                msg += "\nModified name.";
            }
            if (lastName != null) {
                student.setLastName(lastName);
                msg += "\nModified last name.\n";
            }
            if (newSex != null && !newSex.isEmpty()) {
                String upperCaseSex = newSex.toUpperCase();
                if (upperCaseSex.equals("M") || upperCaseSex.equals("F") || upperCaseSex.equals("O")) {
                    student.setSex(Sex.valueOf(upperCaseSex));
                    msg += "Modified Sex\n";
                } else {
                    msg = "\nInvalid Sex Input. Please enter M, F, or O.";
                }
            }

            if (!msg.isEmpty()) {
                msg = "\nSuccessfully modified attributes:\n" + msg;
            }
        } else {
            msg = "\nThe student with the ID " + id + " does not exist.";
        }

        return msg + "\n";
    }

    /**
     * The function validates a given input for sex and returns it if it is either
     * "M", "F", or "O",
     * otherwise it returns null.
     * 
     * @param newSexInput A string representing the new sex input.
     * @return The method is returning a String value.
     */
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

    /**
     * The function modifies the nutritional state of a student by updating their
     * weight and height for a
     * specified date.
     * 
     * @param id     The id parameter is a String that represents the unique
     *               identifier of the student.
     * @param weight The weight parameter is the new weight value that you want to
     *               update for the
     *               student's nutritional state.
     * @param height The height parameter is a Double value representing the height
     *               of the student.
     * @param date   The date parameter is a Calendar object that represents the
     *               date for which the
     *               nutritional state needs to be modified.
     * @return The method is returning a String message.
     */
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
        } else {
            msj = "Student not found.";
        }
        return msj;
    }

    /**
     * The function finds and returns a specific nutritional state of a student
     * based on a given date.
     * 
     * @param student The student parameter is an object of the Student class. It
     *                represents a student
     *                and contains information about their nutritional states.
     * @param date    The "date" parameter is a Calendar object representing a
     *                specific date.
     * @return The method is returning a NutritionalStates object.
     */
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

    /**
     * The function generates a histogram of the BMI (Body Mass Index) of students
     * for two different
     * time periods.
     * 
     * @return The method is returning a string that contains the histograms
     *         generated for the BMI of
     *         students in September 2022 and April 2023.
     */
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
                msj = "\nError: " + e.getMessage() + "\n\n";
            }
            i++;
        } while (i < 2);
        return histogram;
    }

    /**
     * The function `statesListReports` generates a list of BMI reports for students
     * based on different
     * options.
     * 
     * @param option The "option" parameter is an integer that determines the
     *               sorting and
     *               categorization of the student data.
     * @return The method is returning a string message.
     */
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
                msj = "\nError: " + e.getMessage() + "\n\n";
            }
            i++;
        } while (i < 2);
        return msj;
    }

    /**
     * The function returns an ArrayList of Student objects.
     * 
     * @return An ArrayList of Student objects.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * The function sets the list of students for a particular object.
     * 
     * @param students The "students" parameter is an ArrayList of objects of type
     *                 "Student".
     */
    public void setStudentsList(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * The function performs a binary search on an ArrayList of Student objects
     * based on their ID,
     * returning the Student object with the matching ID or null if no match is
     * found.
     * 
     * @param students An ArrayList of Student objects. This is the list of students
     *                 in which we want to
     *                 search for a specific student.
     * @param searchId The searchId parameter is a String representing the ID of the
     *                 student we are
     *                 searching for.
     * @return The method is returning a Student object that matches the searchId,
     *         or null if no match
     *         is found.
     */
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

    /**
     * The function calculates and generates a report on the changes in nutritional
     * states of students.
     * 
     * @return The method is returning a String.
     */
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

    /**
     * The function `indicatorListChangeNutritionalStates` takes an option as input
     * and returns a
     * formatted string indicating the changes in nutritional states of students
     * based on the selected
     * option.
     * 
     * @param option The "option" parameter is an integer that determines the
     *               sorting criteria for the
     *               students.
     * @return The method is returning a String value.
     */
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
        String titleAndSubtitle = "-------Changes in nutritional status-------";
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

    /**
     * The function "loadCategories" adds categories and their descriptions to an
     * ArrayList based on
     * the number of positive and negative changes.
     * 
     * @param categories An ArrayList of Strings that will store the categories.
     * @param plus       The parameter "plus" represents the number of students with
     *                   positive changes.
     * @param less       The "less" parameter represents the number of students with
     *                   negative changes.
     */
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

    /**
     * The function "loadCategoriesList" adds categories to an ArrayList based on
     * the values of "plus"
     * and "less".
     * 
     * @param categories An ArrayList of Strings that will store the categories.
     * @param plus       The "plus" parameter represents the number of students with
     *                   positive changes.
     * @param less       The "less" parameter represents the number of students with
     *                   negative changes.
     */
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
