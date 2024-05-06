import java.util.ArrayList;

public class Course {
    String name;
    String code;
    int credit;
    ArrayList<Student> students;
    Lecturer lecturer;

    public Course(String name, String code, int credit, Lecturer lecturer) {
        this.name = name;
        this.code = code;
        this.credit = credit;
        this.lecturer = lecturer;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + code);
        System.out.println("Credit: " + credit);
        System.out.println("Lecturer: " + lecturer.name);
    }
}