import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int MAX_STUDENTS = 50;
        final int MAX_SUBJECTS = 10;

        String[] studentNames = new String[MAX_STUDENTS];
        int[][] grades = new int[MAX_STUDENTS][MAX_SUBJECTS];
        int[] subjectsCount = new int[MAX_STUDENTS];
        int studentCount = 0;

        int option = 0;

        while (option != 5) {

            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Show Statistics");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                // Add student
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                studentNames[studentCount] = name;

                System.out.print("Enter number of subjects: ");
                int subjectCount = sc.nextInt();
                subjectsCount[studentCount] = subjectCount;

                for (int j = 0; j < subjectCount; j++) {
                    System.out.print("Enter grade for subject " + (j + 1) + ": ");
                    grades[studentCount][j] = sc.nextInt();
                }

                studentCount++;
                System.out.println("Student added successfully!");

            } else if (option == 2) {
                // View all students
                System.out.println("\nAll Students and Grades:");
                for (int i = 0; i < studentCount; i++) {
                    System.out.print(studentNames[i] + " -> [");
                    for (int j = 0; j < subjectsCount[i]; j++) {
                        System.out.print(grades[i][j]);
                        if (j < subjectsCount[i] - 1) System.out.print(", ");
                    }
                    System.out.println("]");
                }

            } else if (option == 3) {
                // Search student
                System.out.print("Enter student name to search: ");
                String nameToSearch = sc.nextLine();
                boolean found = false;

                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i].equalsIgnoreCase(nameToSearch)) {
                        found = true;
                        System.out.print("Found: " + studentNames[i] + "\nGrades: [");
                        int sum = 0;
                        int max = grades[i][0];
                        int min = grades[i][0];

                        for (int j = 0; j < subjectsCount[i]; j++) {
                            int grade = grades[i][j];
                            sum += grade;
                            if (grade > max) max = grade;
                            if (grade < min) min = grade;

                            System.out.print(grade);
                            if (j < subjectsCount[i] - 1)
                                System.out.print(", ");
                        }
                        double average = (double) sum / subjectsCount[i];
                        System.out.printf("]\nAverage: %.2f\nHighest: %d\nLowest: %d\n", average, max, min);
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }

            } else if (option == 4) {
                // Class statistics
                if (studentCount == 0) {
                    System.out.println("No students added yet.");
                    continue;
                }

                int totalStudents = studentCount;
                int totalSum = 0;
                int totalGrades = 0;
                int highest = grades[0][0];
                int lowest = grades[0][0];

                for (int i = 0; i < studentCount; i++) {
                    for (int j = 0; j < subjectsCount[i]; j++) {
                        int grade = grades[i][j];
                        totalSum += grade;
                        totalGrades++;
                        if (grade > highest) highest = grade;
                        if (grade < lowest) lowest = grade;
                    }
                }

                double classAverage = (double) totalSum / totalGrades;

                System.out.println("\nClass Statistics:");
                System.out.println("Total Students: " + totalStudents);
                System.out.println("Highest Grade Overall: " + highest);
                System.out.println("Lowest Grade Overall: " + lowest);
                System.out.printf("Class Average: %.2f\n", classAverage);
            }
        }

        System.out.println("Exiting... Goodbye!");
        sc.close();
    }
}
