import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks!");
                i--;
                continue;
            }

            students.add(new Student(name, marks));
        }

        int total = 0;
        int highest = students.get(0).marks;
        int lowest = students.get(0).marks;

        for (Student s : students) {

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }

        double average = (double) total / students.size();

        System.out.println("\n===== STUDENT REPORT =====");

        for (Student s : students) {
            System.out.println("----------------------");
            System.out.println("Student Name : " + s.name);
            System.out.println("Marks        : " + s.marks);
            if (s.marks >= 90)
                System.out.println("Grade: A");
            else if (s.marks >= 75)
                System.out.println("Grade: B");
            else if (s.marks >= 50)
                System.out.println("Grade: C");
            else
                System.out.println("Grade: Fail");
        }

        System.out.println("\nAverage Marks: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

        sc.close();
    }
}
