import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Student> students = new ArrayList<>();
    public List<Subject> subjects = new ArrayList<>();
    public List<Exam> exams = new ArrayList<>();

    public Database() {
        subjects.add(new Subject("100", "Mathematics"));
        subjects.add(new Subject("101", "Physics"));
        subjects.add(new Subject("102", "Chemistry"));
        subjects.add(new Subject("103", "Biology"));
        subjects.add(new Subject("104", "Computer Science"));
        subjects.add(new Subject("105", "History"));
        subjects.add(new Subject("106", "English Literature"));
        subjects.add(new Subject("107", "Philosophy"));
        subjects.add(new Subject("108", "Economics"));
        subjects.add(new Subject("109", "Art"));

        exams.add(new Exam(1, "100", "2025-12-01", "09:00"));
        exams.add(new Exam(2, "101", "2025-12-01", "12:00"));
        exams.add(new Exam(3, "102", "2025-12-01", "15:00"));
        exams.add(new Exam(4, "103", "2025-12-02", "09:00"));
        exams.add(new Exam(5, "104", "2025-12-02", "12:00"));
        exams.add(new Exam(6, "105", "2025-12-02", "15:00"));
        exams.add(new Exam(7, "106", "2025-12-03", "09:00"));
        exams.add(new Exam(8, "107", "2025-12-03", "12:00"));
        exams.add(new Exam(9, "108", "2025-12-03", "15:00"));
        exams.add(new Exam(10, "109", "2025-12-04", "09:00"));

        String[] names = {
                "Smith, Alice","Johnson, Bob","Williams, Charlie","Brown, David","Jones, Eve",
                "Garcia, Frank","Miller, Grace","Davis, Hannah","Rodriguez, Ivy","Martinez, Jack",
                "Hernandez, Kim","Lopez, Leo","Gonzalez, Mia","Wilson, Nina","Anderson, Oscar",
                "Thomas, Paul","Taylor, Quinn","Moore, Ruth","Jackson, Sam","Martin, Tina",
                "Lee, Uma","Perez, Victor","Thompson, Wendy","White, Xander","Harris, Yara",
                "Sanchez, Zane","Clark, Amy","Ramirez, Brian","Lewis, Catherine","Robinson, Derek",
                "Walker, Elena","Young, Felix","Allen, Gina","King, Harry","Wright, Isla",
                "Scott, Jason","Torres, Katie","Nguyen, Liam","Hill, Megan","Flores, Noah",
                "Green, Olivia","Adams, Peter","Nelson, Quincy","Baker, Rachel","Hall, Steve",
                "Rivera, Tara","Campbell, Ulysses","Mitchell, Vanessa","Carter, Walter","Roberts, Zoe"
        };
        int id = 1001;
        for (String n : names) students.add(new Student(n, id++));
    }
}
