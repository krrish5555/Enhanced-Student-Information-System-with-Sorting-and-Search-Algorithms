import java.util.*;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    private static final StudentInfoSystem sis = new StudentInfoSystem();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nOptions:\n1. Add Student\n2. Remove Student\n3. View Students\n4. View Exam Schedule\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> viewStudents();
                case 4 -> viewExamSchedule();
                case 5 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static int readInt() {
        while (true) {
            try { return Integer.parseInt(keyboard.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.print("Enter a valid number: "); }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name as \"last, first\": ");
        String name = keyboard.nextLine();
        int number = sis.newStudentNumber();

        List<Subject> subjects = sis.sortSubjectsByName();
        System.out.println("Here is a list of subjects available.");
        subjects.forEach(s -> System.out.println(" " + s));

        int count;
        do {
            System.out.print("Enter number of subjects desired (1-5): ");
            count = readInt();
        } while (count < 1 || count > 5);

        List<Subject> chosen = new ArrayList<>();
        List<Exam> chosenExams = new ArrayList<>();
        String[] ord = { "", "first", "second", "third", "fourth", "fifth" };

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter the " + ord[i] + " Subject ID: ");
            String id = keyboard.nextLine().trim();
            Subject sub = sis.findSubject(id);
            if (sub == null || chosen.contains(sub)) { System.out.println("Invalid or duplicate ID"); i--; continue; }
            chosen.add(sub);

            List<Exam> options = sis.findExams(id);
            options.forEach(e -> System.out.println(" " + e));
            Exam picked;
            while (true) {
                System.out.print("Select an exam id: ");
                picked = sis.findExam(readInt(), options);
                if (picked != null) break;
                System.out.println("Invalid exam id");
            }
            chosenExams.add(picked);
        }

        Student st = new Student(name, number);
        st.addSubjects(chosen);
        st.addExams(chosenExams);
        sis.addStudent(st);
        System.out.println("Student " + st + " added.");
    }

    private static void removeStudent() {
        System.out.print("Enter student number to remove: ");
        int num = readInt();
        Student st = sis.findStudent(num);
        if (st == null) { System.out.println("Student not found"); return; }
        sis.removeStudent(st);
        System.out.println("Student " + st + " removed");
    }

    private static void viewStudents() {
        System.out.println("\nStudents (alphabetical):");
        sis.sortStudentsByName().forEach(System.out::println);
    }

    private static void viewExamSchedule() {
        System.out.print("Enter student number: ");
        int num = readInt();
        Student st = sis.findStudent(num);
        if (st == null) { System.out.println("Student not found"); return; }
        System.out.println("Exam Schedule for " + st.getName() + ":");
        for (Subject sub : st.getSubjects()) {
            Exam ex = st.getExamsMap().get(sub.getId());
            if (ex != null) System.out.println(" " + sub.getName() + ": " + ex.getDate() + " " + ex.getTime());
        }
    }
}
