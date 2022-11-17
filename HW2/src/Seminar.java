import java.util.ArrayList;
import java.util.List;

public class Seminar {
    private List<Student> nonAskedStudents;
    private List<Student> askedStudents;

    public List<Student> getNonAskedStudents() {
        return nonAskedStudents;
    }

    public List<Student> getAskedStudents() {
        return askedStudents;
    }

    public void addAskedStudent(Student student) {
        askedStudents.add(student);
    }

    public Seminar() { }

    public Seminar(List<Student> students) {
        this.nonAskedStudents = students;
        this.askedStudents = new ArrayList<>();
    }

    public void printStudents() {
        if (nonAskedStudents.size() != 0) {
            for (var student : nonAskedStudents) {
                System.out.println(student.toString());
            }
        }
        if (askedStudents.size() != 0) {
            for (var student : askedStudents) {
                System.out.println(student.toString());
            }
        }
    }
}
