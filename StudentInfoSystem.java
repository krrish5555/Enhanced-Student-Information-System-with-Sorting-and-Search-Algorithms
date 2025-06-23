import java.util.ArrayList;
import java.util.List;

public class StudentInfoSystem {
    private final Database db = new Database();

    public List<Subject> sortSubjectsByName() {
        List<Subject> list = new ArrayList<>(db.subjects);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getName().compareTo(list.get(j + 1).getName()) > 0) {
                    Subject tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        return list;
    }

    private int compareStudents(Student a, Student b) {
        String lastA = a.getName().split(",")[0].trim();
        String lastB = b.getName().split(",")[0].trim();
        int cmp = lastA.compareTo(lastB);
        return cmp != 0 ? cmp : a.getName().compareTo(b.getName());
    }

    public List<Student> sortStudentsByName() {
        List<Student> list = new ArrayList<>(db.students);
        for (int i = 1; i < list.size(); i++) {
            Student key = list.get(i);
            int j = i - 1;
            while (j >= 0 && compareStudents(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    public List<Student> sortStudentsByNumber() {
        List<Student> list = new ArrayList<>(db.students);
        for (int i = 1; i < list.size(); i++) {
            Student key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getStudentNumber() > key.getStudentNumber()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    public List<Exam> sortExamsBySubjectId() {
        List<Exam> list = new ArrayList<>(db.exams);
        for (int i = 1; i < list.size(); i++) {
            Exam key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getSubjectId().compareTo(key.getSubjectId()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    public Subject findSubject(String id) {
        for (Subject s : db.subjects) if (s.getId().equals(id)) return s;
        return null;
    }

    public List<Exam> findExams(String subjectId) {
        List<Exam> res = new ArrayList<>();
        for (Exam e : sortExamsBySubjectId()) {
            if (e.getSubjectId().equals(subjectId)) {
                res.add(e);
                if (res.size() == 2) break;
            }
        }
        return res;
    }

    public Exam findExam(int examId, List<Exam> list) {
        for (Exam e : list) if (e.getExamId() == examId) return e;
        return null;
    }

    public Student findStudent(int studentNumber) {
        List<Student> list = sortStudentsByNumber();
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int num = list.get(mid).getStudentNumber();
            if (num == studentNumber) return list.get(mid);
            if (num < studentNumber) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public void addStudent(Student s) {
        db.students.add(s);
    }

    public void removeStudent(Student s) {
        db.students.remove(s);
    }

    public int newStudentNumber() {
        List<Student> list = sortStudentsByNumber();
        return list.get(list.size() - 1).getStudentNumber() + 1;
    }

    public List<Subject> sortSubjectsById() {
        return new ArrayList<>(db.subjects);
    }
}
