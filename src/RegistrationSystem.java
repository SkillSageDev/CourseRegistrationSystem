import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrationSystem {
    Collage collage;

    public RegistrationSystem(Collage collage) {
        this.collage = collage;
    }

    // Add the missing methods here
    public void registerStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = "";
        boolean validName = false;
        do {
            name = scanner.nextLine();
            if (name.matches("^[a-zA-Z\\s]+$")) {
                validName = true;
            } else {
                System.out.println("Invalid input. Please enter a valid name.");
            }
        } while (!validName);
        System.out.println("Enter Student Email: ");
        String email = "";
        boolean validEmail = false;
        do {
            email = scanner.nextLine();
            if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                validEmail = true;
            } else {
                System.out.println("Invalid input. Please enter a valid email.");
            }
        } while (!validEmail);
        System.out.println("Enter Student ID: ");
        int id = 0;
        boolean validId = false;
        do {
            try {
                id = scanner.nextInt();
                validId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // Consume newline left-over
            }
        } while (!validId);
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter Student Gender (M/F): ");
        char gender = ' ';
        boolean validGender = false;
        do {
            try {
                gender = scanner.next().charAt(0);
                if (gender != 'M' && gender != 'F') {
                    throw new Exception();
                }
                validGender = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid gender.");
                scanner.nextLine(); // Consume newline left-over
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid gender.");
            }
        } while (!validGender);
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter Student Date of Birth (yyyy-mm-dd): ");
        String dateOfBirth = "";
        boolean validDate = false;
        do {
            dateOfBirth = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                sdf.parse(dateOfBirth);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Invalid input. Please enter a valid date of birth.");
            }
        } while (!validDate);
        System.out.println("Enter Student Address: ");
        String address = "";
        boolean validAddress = false;
        do {
            address = scanner.nextLine();
            if (address.matches("^[#.0-9a-zA-Z\\s,-]+$")) {
                validAddress = true;
            } else {
                System.out.println("Invalid input. Please enter a valid address.");
            }
        } while (!validAddress);

        Student student = new Student(name, email, id, gender, dateOfBirth, address);
        collage.addStudent(student);
        System.out.println("Student added successfully.");
    }

    public void registerLecturer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Lecturer Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Lecturer Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Lecturer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter Lecturer Gender (M/F): ");
        char gender = scanner.next().charAt(0);
        System.out.println("Enter Lecturer Date of Birth (yyyy-mm-dd): ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter Lecturer Address: ");
        String address = scanner.nextLine();

        Lecturer lecturer = new Lecturer(name, email, id, gender, dateOfBirth, address);
        collage.addLecturer(lecturer);
        System.out.println("Lecturer added successfully.");
    }

    public void registerCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Course Code: ");
        String code = scanner.nextLine();
        System.out.println("Enter Course Credit: ");
        int credit = scanner.nextInt();
        System.out.println("Enter Lecturer ID: ");
        int lecturerId = scanner.nextInt();

        for (Lecturer lecturer : collage.lecturers) {
            if (lecturer.id == lecturerId) {
                Course course = new Course(name, code, credit, lecturer);
                collage.addCourse(course);
                lecturer.addCourse(course);
                System.out.println("Course added successfully.");
                return;
            }
        }
        System.out.println("Lecturer not found.");
    }

    // Other methods

    public void registerCourseForStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.println("Enter Course Code: ");
        String courseCode = scanner.next();

        for (Student student : collage.students) {
            if (student.id == studentId) {
                for (Course course : collage.courses) {
                    if (course.code.equals(courseCode)) {
                        student.addCourse(course);
                        course.addStudent(student);
                        System.out.println("Course registered successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Student or Course not found.");
    }

    public void registerCourseForLecturer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Lecturer ID: ");
        int lecturerId = scanner.nextInt();
        System.out.println("Enter Course Code: ");
        String courseCode = scanner.next();

        for (Lecturer lecturer : collage.lecturers) {
            if (lecturer.id == lecturerId) {
                for (Course course : collage.courses) {
                    if (course.code.equals(courseCode)) {
                        course.lecturer = lecturer;
                        lecturer.addCourse(course);
                        System.out.println("Course registered successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Lecturer or Course not found.");
    }

    public void displayCollageInfo() {
        collage.displayCollageInfo();
    }

    public void displayCourses() {
        System.out.println("List of Courses: ");
        for (Course course : collage.courses) {
            course.displayCourseInfo();
        }
    }

    public void displayStudents() {
        System.out.println("List of Students: ");
        for (Student student : collage.students) {
            student.displayDetails();
        }
    }

    public void displayLecturers() {
        System.out.println("List of Lecturers: ");
        for (Lecturer lecturer : collage.lecturers) {
            lecturer.displayDetails();
        }
    }

    public void displayCoursesForStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        int studentId = scanner.nextInt();

        for (Student student : collage.students) {
            if (student.id == studentId) {
                System.out.println("Courses for Student ID: " + studentId);
                for (Course course : student.courses) {
                    course.displayCourseInfo();
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayCoursesForLecturer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Lecturer ID: ");
        int lecturerId = scanner.nextInt();

        for (Lecturer lecturer : collage.lecturers) {
            if (lecturer.id == lecturerId) {
                System.out.println("Courses for Lecturer ID: " + lecturerId);
                for (Course course : lecturer.courses) {
                    course.displayCourseInfo();
                }
                return;
            }
        }
        System.out.println("Lecturer not found.");
    }
}