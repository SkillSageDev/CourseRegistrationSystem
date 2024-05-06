import java.util.ArrayList;

public class Collage {
    String name;
    String location;
    ArrayList<Course> courses;
    ArrayList<Student> students;
    ArrayList<Lecturer> lecturers;

    public Collage(String name, String location) {
        this.name = name;
        this.location = location;
        courses = new ArrayList<>();
        students = new ArrayList<>();
        lecturers = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public void displayCollageInfo() {
        System.out.println("Collage Name: " + name);
        System.out.println("Location: " + location);
    }
}