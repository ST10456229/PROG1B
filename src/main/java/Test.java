/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Test {
     private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add new student");
                System.out.println("2. Search for student");
                System.out.println("3. Delete student");
                System.out.println("4. Print all students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        searchStudent(scanner);
                        break;
                    case 3:
                        deleteStudent(scanner);
                        break;
                    case 4:
                        printStudents();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select again.");
                }
            } while (choice != 5);
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to add a new student
    public static void addStudent(Scanner scanner) {
        try {
            if (studentCount >= MAX_STUDENTS) {
                System.out.println("Cannot add more students. Student limit reached.");
                return;
            }
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student email: ");
            String email = scanner.nextLine();
            System.out.print("Enter student course: ");
            String course = scanner.nextLine();
            students[studentCount++] = new Student(id, name, email, course);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to search for a student
    public static void searchStudent(Scanner scanner) {
        try {
            System.out.print("Enter student ID to search: ");
            int id = scanner.nextInt();
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId() == id) {
                    System.out.println("Student found: " + students[i]);
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to delete a student
    public static void deleteStudent(Scanner scanner) {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = scanner.nextInt();
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId() == id) {
                    // Shift the array elements to remove the student
                    for (int j = i; j < studentCount - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    students[--studentCount] = null;
                    System.out.println("Student deleted successfully.");
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to print all students
    public static void printStudents() {
        try {
            if (studentCount == 0) {
                System.out.println("No students to display.");
            } else {
                for (int i = 0; i < studentCount; i++) {
                    System.out.println(students[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}