import java.util.*;

public class Student {
    private final String name;
    private final int studentNumber;
    private final List<Subject> subjects = new ArrayList<>();
    private final Map<String, Exam> examsMap = new HashMap<>();

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubjects(List<Subject> subs) {
        subjects.clear();
        subjects.addAll(subs);
    }

    public void addExams(List<Exam> exams) {
        examsMap.clear();
        for (Exam e : exams) {
            examsMap.put(e.getSubjectId(), e);
        }
    }

    public Map<String, Exam> getExamsMap() {
        return examsMap;
    }

    @Override
    public String toString() {
        return studentNumber + ": " + name;
    }
}
