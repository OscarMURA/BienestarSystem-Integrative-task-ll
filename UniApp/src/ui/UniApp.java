package ui;

import java.util.ArrayList;
import model.BienestarSystem;
import model.FileManager;
import model.NutritionalStates;
import model.Sex;
import model.Student;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UniApp {

    private BienestarSystem bienestarSystem;
    private FileManager fileManager;
    private Scanner reader;

    public UniApp() {
        bienestarSystem = new BienestarSystem();
        fileManager = FileManager.getInstance();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UniApp uniApp = new UniApp();
        uniApp.menu();
        uniApp.exit();

    }

    public void menu() {
        int choice = 0;
        bienestarSystem.loadStudents();

        do {
            System.out.println("Bienestar University Application");
            System.out.println("1. Add Student");
            System.out.println("2. Modify Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Classification report");
            System.out.println("5. Nutritional changes report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(reader.nextLine());

                switch (choice) {
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
                        print();
                        break;
                    case 6:
                        System.out.println("Exiting the application.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (choice != 6);

        reader.close();
    }

    public void exit() {
        bienestarSystem.saveStudents();
        reader.close();
        System.out.println("Exiting the application.");
        System.exit(0);
    }

    public void addStudent() {
        System.out.print("ID: ");
        String id = reader.nextLine();
        if (bienestarSystem.searchStudent(id)) {
            System.out.println("El id ingresado ya existe");
        } else {
            System.out.print("Name: ");
            String name = reader.nextLine();
            System.out.print("Last Name: ");
            String lastName = reader.nextLine();
            System.out.print("Years: ");
            int years = Integer.parseInt(reader.nextLine());
            System.out.print("Sex (M/F/O): ");
            String sexInput = reader.nextLine();

            Sex sex;
            if (sexInput.equalsIgnoreCase("M")) {
                sex = Sex.M;
            } else if (sexInput.equalsIgnoreCase("F")) {
                sex = Sex.F;
            } else if (sexInput.equalsIgnoreCase("O")) {
                sex = Sex.O;
            } else {
                System.out.println("Invalid sex input. Please enter M, F, or O.");
                return;
            }

            String message = bienestarSystem.addStudents(id, years, name, lastName, sex);
            System.out.println(message);

            nutritionalState(id);

            bienestarSystem.saveStudents();
        }

    }

    public void nutritionalState(String id) {
        System.out.println("Weight Sep 2022: ");
        double weightSep = Double.parseDouble(reader.nextLine());
        System.out.println("Height Sep 2022: ");
        double heightSep = Double.parseDouble(reader.nextLine());
        System.out.println("Weight Apr 2023: ");
        double weightApril = Double.parseDouble(reader.nextLine());
        System.out.println("Height Apr 2023: ");
        double heightApril = Double.parseDouble(reader.nextLine());

        Calendar dateSep = new GregorianCalendar(2023, Calendar.SEPTEMBER, 1);
        NutritionalStates nutritionalStateSep = new NutritionalStates(weightSep, heightSep, dateSep);

        Calendar dateApr = new GregorianCalendar(2023, Calendar.APRIL, 1);
        NutritionalStates nutritionalStateApr = new NutritionalStates(weightApril, heightApril, dateApr);

        String messageSep = bienestarSystem.addNutritionalStateToStudent(id, nutritionalStateSep);
        String messageApr = bienestarSystem.addNutritionalStateToStudent(id, nutritionalStateApr);

        System.out.println("Nutritional state for Sep 2022: " + messageSep);
        System.out.println("Nutritional state for Apr 2023: " + messageApr);

        bienestarSystem.saveStudents();

    }

    public void modifyStudent() {
        System.out.print("Enter student ID to modify: ");
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
                System.out.println("===== Student Modification Menu =====");
                System.out.println("1. Modify Name");
                System.out.println("2. Modify Last Name");
                System.out.println("3. Modify Years");
                System.out.println("4. Modify Sex");
                System.out.println("===== State Nutritional Menu =====");
                System.out.println("5. Modify Height Abr 2023");
                System.out.println("6. Modify Height Sep 2022 ");
                System.out.println("7. Modify Weight Sep 2022 ");
                System.out.println("8. Modify Weight Abr 2023 ");
                System.out.println("0. Return to Main Menu");
                System.out.print("Choose an option: ");

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

            bienestarSystem.saveStudents();
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String id = reader.nextLine();

        String message = bienestarSystem.removedStudent(id);

        if (message.equals("Student removed successfully.")) {
            System.out.println("Student removed successfully.");
            bienestarSystem.saveStudents();
        } else {
            System.out.println(message);
        }

        bienestarSystem.saveStudents();

    }

    public int validateInt() {
        int option = 0;
        do {
            if (reader.hasNextInt()) {
                option = reader.nextInt();
            } else {
                reader.next();// limpiar el scanner
                System.out.println("Invalid number!");
                System.out.print("Conrrently Type: ");
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

                reader.next();// limpiar el scanner
                System.out.println("Invalid number!");
                System.out.print("Conrrently Type: ");
                option = Integer.MAX_VALUE;
            }

        } while (option == Integer.MAX_VALUE);

        return option;
    }

    public void classificationReport() {
        int option = 0;
        do {
            System.out.println("1. Histogram reporting");
            System.out.println("2. Report by listing");
            System.out.println("0. Return to Main Menu");
            System.out.print("Choose an option: ");
            option = validateInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 0);
    }

    public String print() {
        String msj = "";
        ArrayList<Student> students = bienestarSystem.getStudents();
        for (int i = 0; i < students.size(); i++) {
            msj += students.get(i).toString() + "\n";
        }
        return msj;
    }

}
