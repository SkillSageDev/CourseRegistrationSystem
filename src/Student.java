import java.util.ArrayList;

public class Student extends Person {
    ArrayList<Course> courses;

    public Student(String name, String email, int id, char gender, String dateOfBirth, String address) {
        super(name, email, id, gender, dateOfBirth, address);
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Address: " + address);
    }

    @Override
    public void displayDetails() {
        displayStudentInfo();
        System.out.println("Courses: ");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}