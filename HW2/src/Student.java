import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private boolean isPresent;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public boolean getPresent() {
        return this.isPresent;
    }

    public void setGrade(int grade) {
        Scanner in = new Scanner(System.in);
        String answer;
        do {
            System.out.printf("-> Answers student %s %s!\n", getLastName(), getFirstName());
            System.out.print("-> Is student here (yes / no): ");
            answer = in.next();
            switch (answer) {
                case "yes" -> {
                    isPresent = true;
                    this.grade = grade;
                }
                case "no" -> {
                    isPresent = false;
                    this.grade = 0;
                }
                default -> System.out.println("-> Incorrect answer, try again!");
            }
        } while (!answer.equals("yes") && !answer.equals("no"));
        System.out.printf("%s %s gets the grade: %d!\n", this.lastName, this.firstName, this.grade);
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Student() { }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Student ParseStudent(String data) {
        String[] studentInfo = data.split(" ");

        if (studentInfo.length != 2) {
            throw new IllegalArgumentException("Incorrect amount of arguments");
        }

        return new Student(studentInfo[0], studentInfo[1]);
    }

    @Override
    public String toString() {
        return String.format("%s %s with grade: %d", lastName, firstName, grade);
    }
}
