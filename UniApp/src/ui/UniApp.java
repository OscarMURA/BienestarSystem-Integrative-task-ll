package ui;

import model.BienestarSystem;
import model.Sex;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UniApp {

    private BienestarSystem bienestarSystem;
    private Scanner reader;

    public UniApp() {
        bienestarSystem = new BienestarSystem();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UniApp uniApp = new UniApp();
        uniApp.loadStudentJson();
        uniApp.loadStudentsCSV();
        uniApp.loadStudentTxt();
        uniApp.menu();
    }

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

    public void loadStudentJson() {
        bienestarSystem.loadStudentsJson();
    }

    public void saveStudentJson() {
        bienestarSystem.saveStudentsJson();
    }

    public void loadStudentsCSV() {
        bienestarSystem.loadStudentsCSV();
    }

    public void saveStudentCSV() {
        bienestarSystem.saveStudentsCVC();
    }

    public void loadStudentTxt() {
        bienestarSystem.loadStudentsTxt();
    }

    public void saveStudentTxt(String information) {
        bienestarSystem.saveStudentsTxt(information);
    }

    public void addStudent() {
        reader.nextLine();
        boolean validate = false;
        String id = "";

        while (!validate) {
            System.out.println("");
            System.out.println("=========== Add Student ===========" + "\n");
            System.out.print("Ingrese el id: ");
            id = reader.nextLine();

            if (id.length() < 9 || !validateFormatId(id)) {
                System.out.println("\n=================================");
                System.out.println("El ID ingresado no es válido. Formato(A00399425 - A mayuscula).");
                System.out.println("=================================");
            } else if (bienestarSystem.searchStudent(id)) {
                System.out.println("=================================");
                System.out.println("El id ingresado ya existe");
                System.out.println("=================================");
            } else {
                validate = true;
            }
        }

        System.out.print("Ingrese el Name: ");
        String name = reader.nextLine();
        System.out.print("Ingrese el Last Name: ");
        String lastName = reader.nextLine();
        System.out.print("Ingrese cuantos años tiene: ");
        int years = Integer.parseInt(reader.nextLine());
        System.out.print("Ingrese su Sex (M/F/O): ");
        String sexInput = reader.nextLine();

        Sex sex;
        if (sexInput.equalsIgnoreCase("M")) {
            sex = Sex.M;
        } else if (sexInput.equalsIgnoreCase("F")) {
            sex = Sex.F;
        } else if (sexInput.equalsIgnoreCase("O")) {
            sex = Sex.O;
        } else {
            System.out.println("===========================================");
            System.out.println("Invalid sex input. Please enter M, F, or O.");
            System.out.println("===========================================");
            return;
        }

        String message = bienestarSystem.addStudents(id, years, name, lastName, sex);
        System.out.println(message);

        nutritionalState(id);
        saveStudentJson();
        saveStudentCSV();
    }

    public void nutritionalState(String id) {
        System.out.println("");
        System.out.println("=========== Add Nutritional State ===========" + "\n");
        System.out.println("Ingrese su Weight Sep 2022: ");
        double weightSep = Double.parseDouble(reader.nextLine());
        System.out.println("Ingrese su Height Sep 2022: ");
        double heightSep = Double.parseDouble(reader.nextLine());
        System.out.println("Ingrese su Weight Apr 2023: ");
        double weightApril = Double.parseDouble(reader.nextLine());
        System.out.println("Ingrese su Height Apr 2023: ");
        double heightApril = Double.parseDouble(reader.nextLine());

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

    public void modifyStudent() {
        System.out.println("===========================================");
        System.out.print("Enter student ID to modify:\n");
        System.out.println("===========================================");
        String id = reader.nextLine();

        if (bienestarSystem.searchStudent(id)) {
            String newName = null;
            String newLastName = null;
            int newYears = 0;
            Sex newSex = null;
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
                        System.out.print("New Sex (M/F/O): ");
                        String newSexInput = reader.nextLine();
                        if (!newSexInput.isBlank()) {
                            if (newSexInput.equalsIgnoreCase("M")) {
                                newSex = Sex.M;
                            } else if (newSexInput.equalsIgnoreCase("F")) {
                                newSex = Sex.F;
                            } else if (newSexInput.equalsIgnoreCase("O")) {
                                newSex = Sex.O;
                            } else {
                                System.out.println("Invalid sex input. Please enter M, F, or O.");
                            }
                        }
                        break;
                    case 5:
                        System.out.print("New Height Abr 2023: ");
                        newHealthAbr = validateDouble();
                        break;
                    case 6:
                        System.out.print("New Height Sep 2022: ");
                        newHealthSep = validateDouble();
                        break;
                    case 7:
                        System.out.print("New Weight Sep 2022: ");
                        newWeightSep = validateDouble();
                        break;
                    case 8:
                        System.out.print("New Weight Abr 2023: ");
                        newWeightApr = validateDouble();
                        break;
                }
            } while (modifyChoice != 0);

            Calendar newDateAbr2023 = new GregorianCalendar(2023, Calendar.APRIL, 1);
            Calendar newDateSep2022 = new GregorianCalendar(2022, Calendar.SEPTEMBER, 1);

            String modifyMessage = bienestarSystem.modifyStudent(id, newYears, newName, newLastName, newSex);
            modifyMessage += bienestarSystem.modifyNutritionalStudent(id, newWeightSep, newHealthSep, newDateSep2022);
            modifyMessage += bienestarSystem.modifyNutritionalStudent(id, newWeightApr, newHealthAbr, newDateAbr2023);

            System.out.println(modifyMessage);
            saveStudentJson();
            saveStudentCSV();

        } else {
            System.out.println("===========================================");
            System.out.println("Student with ID " + id + " not found.");
            System.out.println("===========================================");
        }
    }

    public void removeStudent() {
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

    public void classificationReport() {
        int option = 0;
        do {
            System.out.println("===========================================");
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
                    saveStudentTxt(histogram);
                    System.out.println(histogram);
                    break;
                case 2:
                    String reportList = menuListReport();
                    saveStudentTxt(reportList);
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

    public void nutritionalStateReport() {
        int option = 0;
        do {
            System.out.println("===========================================");
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
                    saveStudentTxt(indicatorReport);
                    System.out.println(indicatorReport);
                    break;
                case 2:
                    String reportListIndicator = menuListReportIndicator();
                    saveStudentTxt(reportListIndicator);
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

    public String menuListReport() {
        int optionReport = 0;
        System.out.println("======================================================");
        System.out.println("Ingrese el tipo de orden que desea realizar su reporte");
        System.out.println("======================================================");
        System.out.println("1. BMI");
        System.out.println("2. Age");
        System.out.println("3. Alphabetical");
        System.out.println("0. Return to Main Menu");
        System.out.println("======================================================");
        optionReport = validateInt();
        String report = bienestarSystem.statesListReports(optionReport);

        return report;
    }

    public String menuListReportIndicator() {
        int optionReport = 0;
        System.out.println("======================================================");
        System.out.println("Ingrese el tipo de orden que desea realizar su reporte");
        System.out.println("======================================================");
        System.out.println("1. BMI");
        System.out.println("2. Age");
        System.out.println("3. Alphabetical");
        System.out.println("0. Return to Main Menu");
        System.out.println("======================================================");
        optionReport = validateInt();
        String report = bienestarSystem.indicatorListChangeNutritionalStates(optionReport);

        return report;
    }

}
