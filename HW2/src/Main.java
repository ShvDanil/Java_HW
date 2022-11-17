import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String FilePath = "/Users/shvetsovdanil/Desktop/Java_HW/HW2/students_info";

    private static void writeSthToContinue() {
        Scanner in = new Scanner(System.in);
        in.next();
    }

    private static void printWelcomeMessage() {
        System.out.print("Hello! Welcome to console application.\nWrite sth to continue: ");
        writeSthToContinue();
    }

    private static void printSeparator() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }

    private static void printInstructions() {
        System.out.println("""
                How does this application work? All's really simple!
                /h - write it once to start seminar
                /r - choose random student
                /l - list of student with grades
                /i - instructions
                /e - write it to stop application execution""");
    }

    private static List<Student> readStudentsFromFile(String inputPath) throws IOException {
        List<Student> students = new ArrayList<>();

        File file = new File(inputPath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        while (line != null) {
            Student student = Student.ParseStudent(line);
            students.add(student);
            line = bufferedReader.readLine();
        }

        return students;
    }

    private static void printGoodbyeMessage() {
        printSeparator();
        System.out.println("Thank you for being with us! Bye))");
    }

    public static void main(String[] args) throws IOException {
        printWelcomeMessage();
        printSeparator();
        printInstructions();
        printSeparator();

        boolean hasSeminarStarted = false;
        List<Student> students;
        try {
            students = readStudentsFromFile(FilePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Seminar seminar = new Seminar(students);

        Scanner in = new Scanner(System.in);
        Random randomizer = new Random();

        String command;
        do {
            System.out.print("-> ");
            command = in.nextLine();
            switch (command) {
                case "/h":
                    if (hasSeminarStarted) {
                        System.out.println("-> The seminar has already started!!");
                        continue;
                    }
                    System.out.println("-> The seminar has started right now!!! Let's go!");
                    hasSeminarStarted = true;
                    break;
                case "/r":
                    if (!hasSeminarStarted) {
                        System.out.println("-> The seminar hasn't started yet.");
                        continue;
                    }

                    if (seminar.getNonAskedStudents().size() == 0) {
                        break;
                    }

                    Student randomStudent = seminar.getNonAskedStudents().remove(randomizer.nextInt(seminar.getNonAskedStudents().size()));
                    randomStudent.setGrade(randomizer.nextInt(1, 11));
                    seminar.addAskedStudent(randomStudent);

                    break;
                case "/l":
                    if (!hasSeminarStarted) {
                        System.out.println("-> The seminar hasn't started yet.");
                        continue;
                    }
                    printSeparator();
                    seminar.printStudents();
                    printSeparator();
                    break;
                case "/i":
                    printSeparator();
                    printInstructions();
                    printSeparator();
                    break;
                case "/e":
                    break;
                default:
                    System.out.println("-> Incorrect command was entered!");
            }
            if (seminar.getNonAskedStudents().size() == 0) {
                System.out.println("-> You've already asked all students! That's all for now.");
                break;
            }
        } while (!command.equals("/e"));
        in.close();

        printGoodbyeMessage();
    }
}