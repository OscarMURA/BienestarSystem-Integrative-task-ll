package ui;

import model.BienestarSystem;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The UniApp class is a Java class.
 */
public class UniApp {

    private BienestarSystem bienestarSystem;
    private Scanner reader;

    // The above code is defining a constructor for the UniApp class. It initializes
    // a new instance of
    // the BienestarSystem class and a new instance of the Scanner class, which
    // reads input from the
    // System.in stream.
    public UniApp() {
        bienestarSystem = new BienestarSystem();
        reader = new Scanner(System.in);
    }

    /**
     * The main function initializes an instance of the UniApp class, loads student
     * data from JSON,
     * CSV, and TXT files, and then displays the menu for the application.
     */
    public static void main(String[] args) {
        UniApp uniApp = new UniApp();
        uniApp.loadStudentJson();
        uniApp.loadStudentsCSV();
        uniApp.loadStudentTxt();
        uniApp.menu();
    }

    /**
     * The menu function displays a menu of options for a university application and
     * allows the user to
     * select an option.
     */
    public void menu() {
        int optionMenu = 0;

        do {
            System.out.println("");
            System.out.println("=========== Main Menu ===========");
            System.out.println("Bienestar University Application");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Modify Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Classification report");
            System.out.println("5. Nutritional changes report");
            System.out.println("6. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice:\n");
            System.out.println("=================================");

            optionMenu = validateInt();

            switch (optionMenu) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    modifyStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    classificationReport();
                    break;
                case 5:
                    nutritionalStateReport();
                    break;
                case 6:
                    System.out.println("=================================");
                    System.out.println("Exiting the application.");
                    System.out.println("=================================");
                    break;
                default:
                    System.out.println("=================================");
                    System.out.println("Invalid. Please enter a valid option.");
                    System.out.println("=================================");
                    break;
            }

        } while (optionMenu != 6);

        reader.close();
    }

    /**
     * The function "loadStudentJson" loads student data from a JSON file into the
     * bienestarSystem.
     */
    public void loadStudentJson() {
        bienestarSystem.loadStudentsJson();
    }

    /**
     * The function "saveStudentJson" saves student data in JSON format.
     */
    public void saveStudentJson() {
        bienestarSystem.saveStudentsJson();
    }

    /**
     * The function "loadStudentsCSV" loads student data from a CSV file into the
     * bienestarSystem.
     */
    public void loadStudentsCSV() {
        bienestarSystem.loadStudentsCSV();
    }

    /**
     * The function "saveStudentCSV" saves student data in CSV format using the
     * bienestarSystem object.
     */
    public void saveStudentCSV() {
        bienestarSystem.saveStudentsCVC();
    }

    /**
     * The function "loadStudentTxt" loads student data from a text file into the
     * bienestarSystem.
     */
    public void loadStudentTxt() {
        bienestarSystem.loadStudentsTxt();
    }

    /**
     * The function saves student information to a text file in a bienestar system.
     * 
     * @param information The "information" parameter is a string that contains the
     *                    data or information
     *                    about a student that needs to be saved.
     */
    public void saveStudentTxt(String path, String information) {
        bienestarSystem.saveStudentsTxt(path, information);
    }

    /**
     * The function "addStudent" prompts the user to enter information about a
     * student, validates the
     * input, and adds the student to the system.
     */
    public void addStudent() {
        reader.nextLine();
        boolean validate = false;
        String id = "";
        String sex = "";
        int years = 0;

        while (!validate) {
            System.out.println("");
            System.out.println("=========== Add Student ===========" + "\n");
            System.out.print("Ingrese el id: ");
            id = reader.nextLine();

            if (id.length() < 9 || !validateFormatId(id)) {
                System.out.println("\n=================================");
                System.out.println("The ID entered is invalid. Format(A00399425 - A uppercase).");
                System.out.println("=================================");
            } else if (bienestarSystem.searchStudent(id)) {
                System.out.println("=================================");
                System.out.println("The entered id already exists");
                System.out.println("=================================");
            } else {
                validate = true;
            }
        }

        System.out.print("Enter the Name: ");
        String name = reader.nextLine();
        System.out.print("Enter the Last Name: ");
        String lastName = reader.nextLine();
        do {
            System.out.print("Enter how old you are: ");
            years = validateInt();
            if (years <= 0) {
                System.out.println("===========================================");
                System.out.println("Invalid years input. Years must be greater than 0.");
                System.out.println("===========================================");
            }
        } while (years <= 0);

        do {
            reader.nextLine();
            System.out.print("Enter your Sex (M/F/O): ");
            String sexInput = reader.nextLine();
            sex = bienestarSystem.validateSex(sexInput);

            if (sex != null) {
                String message = bienestarSystem.addStudents(id, years, name, lastName, sex);
                System.out.println(message);
                nutritionalState(id);
                saveStudentJson();
                saveStudentCSV();
            } else {
                System.out.println("===========================================");
                System.out.println("Invalid sex input. Please enter M, F, or O.");
                System.out.println("===========================================");
            }
        } while (sex == null);
    }

    /**
     * The `nutritionalState` function prompts the user to enter weight and height
     * measurements for
     * September 2022 and April 2023, validates the input, creates `Calendar`
     * objects for the respective
     * dates, calls the `addNutritionalStateToStudent` method with the provided
     * data, and saves the
     * student's information in JSON and CSV formats.
     * 
     * @param id The "id" parameter is a string that represents the unique
     *           identifier of a student.
     */
    public void nutritionalState(String id) {
        System.out.println("");
        System.out.println("=========== Add Nutritional State ===========" + "\n");

        double weightSep, heightSep, weightApril, heightApril;

        do {
            System.out.println("Enter the Weight Sep 2022: ");
            weightSep = validateDouble();
            if (weightSep <= 0) {
                System.out.println("Weight must be greater than 0.");
            }
        } while (weightSep <= 0);

        do {
            System.out.println("Enter the Height Sep 2022: (Ejem: 1.70)");
            heightSep = validateDouble();
            if (heightSep <= 0) {
                System.out.println("Height must be greater than 0.");
            }
        } while (heightSep <= 0);

        do {
            System.out.println("Enter the Weight Apr 2023: ");
            weightApril = validateDouble();
            if (weightApril <= 0 || weightApril <= weightSep) {
                System.out.println(
                        "The April 2023 weight must be greater than the September 2022 weight and greater than 0..");
            }
        } while (weightApril <= 0 || weightApril <= weightSep);

        do {
            System.out.println("Enter your Height Apr 2023: (Ejem: 1.70)");
            heightApril = validateDouble();
            if (heightApril <= 0 || heightApril <= heightSep) {
                System.out.println(
                        "The April 2023 height should be greater than the September 2022 height and greater than 0.");
            }
        } while (heightApril <= 0 || heightApril <= heightSep);

        Calendar dateSep = new GregorianCalendar(2023, Calendar.SEPTEMBER, 1);
        Calendar dateApr = new GregorianCalendar(2023, Calendar.APRIL, 1);

        String messageSep = bienestarSystem.addNutritionalStateToStudent(id, weightSep, heightSep, dateSep);
        String messageApr = bienestarSystem.addNutritionalStateToStudent(id, weightApril, heightApril, dateApr);
        System.out.println("===========================================");
        System.out.println("Nutritional state for Sep 2022: " + messageSep);
        System.out.println("Nutritional state for Apr 2023: " + messageApr);
        System.out.println("===========================================");
        saveStudentJson();
        saveStudentCSV();
    }

    /**
     * The `modifyStudent()` function allows the user to modify various attributes
     * of a student, such
     * as their name, age, sex, and nutritional data.
     */
    public void modifyStudent() {
        reader.nextLine();
        System.out.println("===========================================");
        System.out.print("Enter student ID to modify:\n");
        System.out.println("===========================================");
        String id = reader.nextLine();

        if (bienestarSystem.searchStudent(id)) {
            String newName = null;
            String newLastName = null;
            int newYears = 0;
            String newSex = null;
            double newHealthAbr = 0.0;
            double newHealthSep = 0.0;
            double newWeightApr = 0.0;
            double newWeightSep = 0.0;

            int modifyChoice;

            do {
                System.out.println("===== Student Modification Menu =====" + "\n");
                System.out.println("1. Modify Name");
                System.out.println("2. Modify Last Name");
                System.out.println("3. Modify Years");
                System.out.println("4. Modify Sex");
                System.out.println("");
                System.out.println("===== State Nutritional Menu =====" + "\n");
                System.out.println("5. Modify Height Abr 2023");
                System.out.println("6. Modify Height Sep 2022 ");
                System.out.println("7. Modify Weight Sep 2022 ");
                System.out.println("8. Modify Weight Abr 2023 ");
                System.out.println("0. Return to Main Menu");
                System.out.println("");
                System.out.println("===========================================");
                System.out.print("Choose an option:\n");
                System.out.println("===========================================");

                modifyChoice = validateInt();
                reader.nextLine();

                switch (modifyChoice) {
                    case 1:
                        System.out.print("New Name: ");
                        newName = reader.nextLine();
                        break;
                    case 2:
                        System.out.print("New Last Name: ");
                        newLastName = reader.nextLine();
                        break;
                    case 3:
                        System.out.print("New Years: ");
                        newYears = validateInt();
                        break;
                    case 4:
                        do {
                            System.out.print("New Sex (M/F/O): ");
                            String newSexInput = reader.nextLine();
                            newSex = bienestarSystem.validateSex(newSexInput);
                            if (newSex == null) {
                                System.out.println("===========================================");
                                System.out.println("Invalid sex input. Please enter M, F, or O.");
                                System.out.println("===========================================");
                            }
                        } while (newSex == null);
                        break;
                    case 5:
                        do {
                            System.out.print("New Height Abr 2023: (Ejem: 1.70) ");
                            newHealthAbr = validateDouble();
                            if (newHealthAbr <= 0) {
                                System.out.println("===========================================");
                                System.out.println("The height must be greater than 0.");
                                System.out.println("===========================================");
                            }
                        } while (newHealthAbr <= 0);
                        break;
                    case 6:
                        do {
                            System.out.print("New Height Sep 2022: (Ejem: 1.70) ");
                            newHealthSep = validateDouble();
                            if (newHealthSep <= 0) {
                                System.out.println("===========================================");
                                System.out.println("The height must be greater than 0.");
                                System.out.println("===========================================");
                            }
                        } while (newHealthSep <= 0);
                        break;
                    case 7:
                        do {
                            System.out.print("New Weight Sep 2022: ");
                            newWeightSep = validateDouble();
                            if (newWeightSep <= 0) {
                                System.out.println("===========================================");
                                System.out.println("The weight must be greater than 0.");
                                System.out.println("===========================================");
                            }
                        } while (newWeightSep <= 0);
                        break;
                    case 8:
                        do {
                            System.out.print("New Weight Abr 2023: ");
                            newWeightApr = validateDouble();
                            if (newWeightApr <= 0 || newWeightApr <= newWeightSep) {
                                System.out.println("===========================================");
                                System.out.println(
                                        "The April 2023 weight must be greater than the September 2022 weight and greater than 0.");
                                System.out.println("===========================================");
                            }
                        } while (newWeightApr <= 0 || newWeightApr <= newWeightSep);
                        break;
                }
            } while (modifyChoice != 0);

            Calendar newDateAbr2023 = new GregorianCalendar(2023, Calendar.APRIL, 1);
            Calendar newDateSep2022 = new GregorianCalendar(2022, Calendar.SEPTEMBER, 1);

            String modifyMessage = bienestarSystem.modifyStudent(id, newYears, newName, newLastName, newSex);
            bienestarSystem.modifyNutritionalStudent(id, newWeightSep, newHealthSep, newDateSep2022);
            bienestarSystem.modifyNutritionalStudent(id, newWeightApr, newHealthAbr, newDateAbr2023);

            System.out.println(modifyMessage);
            saveStudentJson();
            saveStudentCSV();

        } else {
            System.out.println("===========================================");
            System.out.println("Student with ID " + id + " not found.");
            System.out.println("===========================================");
        }
    }

    /**
     * The function removes a student from the system based on their ID and saves
     * the updated student
     * data in JSON and CSV formats.
     */
    public void removeStudent() {
        reader.nextLine();
        System.out.println("===========================================");
        System.out.print("Enter student ID to remove:\n");
        System.out.println("===========================================");
        String id = reader.nextLine();

        String message = bienestarSystem.removedStudent(id);

        if (message.equals("Student removed successfully.")) {
            System.out.println("Student removed successfully.");
            bienestarSystem.saveStudentsJson();
        } else {
            System.out.println(message);
        }

        saveStudentJson();
        saveStudentCSV();
    }

    /**
     * The function "validateInt" reads an integer input from the user and validates
     * it, returning the
     * valid integer.
     * 
     * @return The method is returning an integer value.
     */
    public int validateInt() {
        int option = 0;
        do {
            if (reader.hasNextInt()) {
                option = reader.nextInt();
            } else {
                reader.next();
                System.out.println("===========================================");
                System.out.println("Invalid number!");
                System.out.print("Conrrently Type:\n");
                System.out.println("===========================================");
                option = Integer.MAX_VALUE;
            }
        } while (option == Integer.MAX_VALUE);
        return option;
    }

    /**
     * The function "validateDouble" reads a double value from user input and
     * validates it, returning
     * the valid double value.
     * 
     * @return The method is returning a double value.
     */
    public double validateDouble() {
        double option = 0;
        do {
            if (reader.hasNextDouble()) {
                option = reader.nextDouble();
            } else {

                reader.next();
                System.out.println("===========================================");
                System.out.println("Invalid number!");
                System.out.print("Conrrently Type:\n");
                System.out.println("===========================================");

                option = Integer.MAX_VALUE;
            }

        } while (option == Integer.MAX_VALUE);

        return option;
    }

    /**
     * The function `validateFormatId` checks if a given ID string follows a
     * specific format.
     * 
     * @param id The parameter "id" is a string representing an identification
     *           number.
     * @return The method is returning a boolean value, which indicates whether the
     *         given ID string is
     *         valid or not.
     */
    public boolean validateFormatId(String id) {
        boolean esValido = true;

        if (id.length() < 9) {
            esValido = false;
        }

        if (!id.startsWith("A00")) {
            esValido = false;
        }

        for (int i = 3; i < 9; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                esValido = false;
            }
        }

        return esValido;
    }

    /**
     * The function validates input data for years, height, and weight, and returns
     * a validation
     * message if any of the inputs are invalid.
     * 
     * @param newYears     The number of years.
     * @param newHealthSep Height in September 2022
     * @param newHealthAbr The height in April 2023.
     * @param newWeightSep The weight in September 2022.
     * @param newWeightApr The weight in April 2023.
     * @return The method is returning a validation message as a String.
     */
    public String validateData(int newYears, double newHealthSep, double newHealthAbr, double newWeightSep,
            double newWeightApr) {
        String validationMessage = "";

        if (newYears <= 0) {
            validationMessage += "Invalid years input. Years must be greater than 0.\n";
        }

        if (newHealthSep <= 0 || newHealthAbr < newHealthSep) {
            validationMessage += "Invalid height input. Height in April 2023 must be greater than height in September 2022.\n";
        }

        if (newWeightSep <= 0 || newWeightApr < newWeightSep) {
            validationMessage += "Invalid weight input. Weight in April 2023 must be greater or equal to the weight in September 2022.\n";
        }

        return validationMessage;
    }

    /**
     * The classificationReport() function displays a menu of reporting options and
     * allows the user to
     * choose between generating a histogram report, a report by listing, or
     * returning to the main
     * menu.
     */
    public void classificationReport() {
        int option = 0;
        do {
            System.out.println("=========== Menu Reports ===========");
            System.out.println("1. Histogram reporting");
            System.out.println("2. Report by listing");
            System.out.println("0. Return to Main Menu");
            System.out.println("===========================================");
            System.out.print("Choose an option:\n");
            System.out.println("===========================================");
            option = validateInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    String histogram = bienestarSystem.histogramGenerator();
                    saveStudentTxt("/resources/Histogram.txt", histogram);
                    System.out.println(histogram);
                    break;
                case 2:
                    String reportList = menuListReport();
                    saveStudentTxt("/resources/Report_Order_List.txt", reportList);
                    System.out.println(reportList);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("===========================================");
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("===========================================");
                    break;
            }

        } while (option != 0);
    }

    /**
     * The function "nutritionalStateReport" displays a menu of options for
     * generating nutritional state
     * reports and allows the user to choose an option.
     */
    public void nutritionalStateReport() {
        int option = 0;
        do {
            System.out.println("=========== Menu Reports ===========");
            System.out.println("1. Indicator reporting");
            System.out.println("2. Report by listing");
            System.out.println("0. Return to Main Menu");
            System.out.println("===========================================");
            System.out.print("Choose an option:\n");
            System.out.println("===========================================");
            option = validateInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    String indicatorReport = bienestarSystem.indicatorChangesNutritionalStates();
                    saveStudentTxt("/resources/Indicator_Report.txt", indicatorReport);
                    System.out.println(indicatorReport);
                    break;
                case 2:
                    String reportListIndicator = menuListReportIndicator();
                    saveStudentTxt("/resources/List_Report.txt", reportListIndicator);
                    System.out.println(reportListIndicator);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("===========================================");
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("===========================================");
                    break;
            }

        } while (option != 0);
    }

    /**
     * The function displays a menu for selecting the type of order to report on and
     * returns the report
     * based on the selected option.
     * 
     * @return The method is returning a String value, which is the report generated
     *         based on the
     *         user's selected option.
     */
    public String menuListReport() {
        String report = "";
        int optionReport = 0;
        System.out.println("======================================================");
        System.out.println("Enter the type of order you wish to report on");
        System.out.println("======================================================");
        System.out.println("1. BMI");
        System.out.println("2. Age");
        System.out.println("3. Alphabetical");
        System.out.println("0. Return to Main Menu");
        System.out.println("======================================================");
        optionReport = validateInt();
        if (optionReport < 0 || optionReport > 3) {
            System.out.println("===========================================");
            System.out.println("Invalid option. Please try again.");
            System.out.println("===========================================");
        } else {
            report = bienestarSystem.statesListReports(optionReport);
        }

        return report;
    }

    /**
     * The function displays a menu for selecting the type of order to report on and
     * returns the
     * corresponding report.
     * 
     * @return The method is returning a String variable named "report".
     */
    public String menuListReportIndicator() {
        String report = "";
        int optionReport = 0;
        System.out.println("======================================================");
        System.out.println("Enter the type of order you wish to report on");
        System.out.println("======================================================");
        System.out.println("1. BMI");
        System.out.println("2. Age");
        System.out.println("3. Alphabetical");
        System.out.println("0. Return to Main Menu");
        System.out.println("======================================================");
        optionReport = validateInt();
        if (optionReport < 0 || optionReport > 3) {
            System.out.println("===========================================");
            System.out.println("Invalid option. Please try again.");
            System.out.println("===========================================");
        } else {
            report = bienestarSystem.indicatorListChangeNutritionalStates(optionReport);
        }

        return report;
    }

}
