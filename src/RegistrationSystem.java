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
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validId);
        scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
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
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid gender.");
            }
        } while (!validGender);
        scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
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

    public void lecturerRegister() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        boolean validName = false;
        do {
            System.out.println("Enter Lecturer Name: ");
            name = scanner.nextLine();
            if (name.matches("^[a-zA-Z\\s]+$")) {
                validName = true;
            } else {
                System.out.println("Invalid input. Please enter a valid name.");
            }
        } while (!validName);
    
        String email = "";
        boolean validEmail = false;
        do {
            System.out.println("Enter Lecturer Email: ");
            email = scanner.nextLine();
            if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                validEmail = true;
            } else {
                System.out.println("Invalid input. Please enter a valid email.");
            }
        } while (!validEmail);
    
        int id = 0;
        boolean validId = false;
        do {
            try {
                System.out.println("Enter Lecturer ID: ");
                id = scanner.nextInt();
                validId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validId);
    
        char gender = ' ';
        boolean validGender = false;
        do {
            try {
                System.out.println("Enter Lecturer Gender (M/F): ");
                gender = scanner.next().charAt(0);
                if (gender != 'M' && gender != 'F') {
                    throw new Exception();
                }
                validGender = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid gender.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid gender.");
            }
        } while (!validGender);
    
        scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
    
        String dateOfBirth = "";
        boolean validDate = false;
        do {
            System.out.println("Enter Lecturer Date of Birth (yyyy-mm-dd): ");
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
    
        String address = "";
        boolean validAddress = false;
        do {
            System.out.println("Enter Lecturer Address: ");
            address = scanner.nextLine();
            if (address.matches("^[#.0-9a-zA-Z\\s,-]+$")) {
                validAddress = true;
            } else {
                System.out.println("Invalid input. Please enter a valid address.");
            }
        } while (!validAddress);
    
        Lecturer lecturer = new Lecturer(name, email, id, gender, dateOfBirth, address);
        collage.addLecturer(lecturer);
        System.out.println("Lecturer added successfully.");
    }

    public void registerCourse() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        boolean validName = false;
        do {
            System.out.println("Enter Course Name: ");
            name = scanner.nextLine();
            if (name.matches("^[a-zA-Z\\s]+$")) {
                validName = true;
            } else {
                System.out.println("Invalid input. Please enter a valid name.");
            }
        } while (!validName);
    
        String code = "";
        boolean validCode = false;
        do {
            System.out.println("Enter Course Code: ");
            code = scanner.nextLine();
            if (code.matches("^[a-zA-Z0-9]+$")) {
                validCode = true;
            } else {
                System.out.println("Invalid input. Please enter a valid code.");
            }
        } while (!validCode);
    
        int credit = 0;
        boolean validCredit = false;
        do {
            try {
                System.out.println("Enter Course Credit: ");
                credit = scanner.nextInt();
                validCredit = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid credit.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validCredit);
    
        int lecturerId = 0;
        boolean validLecturerId = false;
        do {
            try {
                System.out.println("Enter Lecturer ID: ");
                lecturerId = scanner.nextInt();
                validLecturerId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validLecturerId);
    
        Lecturer foundLecturer = null;
        for (Lecturer lecturer : collage.lecturers) {
            if (lecturer.id == lecturerId) {
                foundLecturer = lecturer;
                break;
            }
        }
    
        if (foundLecturer != null) {
            Course course = new Course(name, code, credit, foundLecturer);
            collage.addCourse(course);
            foundLecturer.addCourse(course);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Lecturer not found.");
        }
    }

    // Other methods

    public void registerCourseForStudent() {
        Scanner scanner = new Scanner(System.in);
        int studentId = 0;
        boolean validStudentId = false;
        do {
            try {
                System.out.println("Enter Student ID: ");
                studentId = scanner.nextInt();
                validStudentId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validStudentId);
    
        String courseCode = "";
        boolean validCourseCode = false;
        do {
            System.out.println("Enter Course Code: ");
            courseCode = scanner.next();
            validCourseCode = true;
        } while (!validCourseCode);
    
        Student foundStudent = null;
        for (Student student : collage.students) {
            if (student.id == studentId) {
                foundStudent = student;
                break;
            }
        }
    
        Course foundCourse = null;
        for (Course course : collage.courses) {
            if (course.code.equals(courseCode)) {
                foundCourse = course;
                break;
            }
        }
    
        if (foundStudent != null && foundCourse != null) {
            foundStudent.addCourse(foundCourse);
            foundCourse.addStudent(foundStudent);
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    public void registerCourseForLecturer() {
        Scanner scanner = new Scanner(System.in);
        int lecturerId = 0;
        boolean validLecturerId = false;
        do {
            try {
                System.out.println("Enter Lecturer ID: ");
                lecturerId = scanner.nextInt();
                validLecturerId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validLecturerId);
    
        String courseCode = "";
        boolean validCourseCode = false;
        do {
            System.out.println("Enter Course Code: ");
            courseCode = scanner.next();
            validCourseCode = true;
        } while (!validCourseCode);
    
        Lecturer foundLecturer = null;
        for (Lecturer lecturer : collage.lecturers) {
            if (lecturer.id == lecturerId) {
                foundLecturer = lecturer;
                break;
            }
        }
    
        Course foundCourse = null;
        for (Course course : collage.courses) {
            if (course.code.equals(courseCode)) {
                foundCourse = course;
                break;
            }
        }
    
        if (foundLecturer != null && foundCourse != null) {
            foundCourse.lecturer = foundLecturer;
            foundLecturer.addCourse(foundCourse);
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Lecturer or Course not found.");
        }
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
        int studentId = 0;
        boolean validStudentId = false;
        do {
            try {
                System.out.println("Enter Student ID: ");
                studentId = scanner.nextInt();
                validStudentId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validStudentId);
    
        Student foundStudent = null;
        for (Student student : collage.students) {
            if (student.id == studentId) {
                foundStudent = student;
                break;
            }
        }
    
        if (foundStudent != null) {
            System.out.println("Courses for Student ID: " + studentId);
            for (Course course : foundStudent.courses) {
                course.displayCourseInfo();
            }
        } else {
            System.out.println("Student not found.");
        }
    }
    
    public void displayCoursesForLecturer() {
        Scanner scanner = new Scanner(System.in);
        int lecturerId = 0;
        boolean validLecturerId = false;
        do {
            try {
                System.out.println("Enter Lecturer ID: ");
                lecturerId = scanner.nextInt();
                validLecturerId = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid ID.");
                scanner.nextLine(); // عشان ياخذ السطر الفاضي الي اتعمل
            }
        } while (!validLecturerId);
    
        Lecturer foundLecturer = null;
        for (Lecturer lecturer : collage.lecturers) {
            if (lecturer.id == lecturerId) {
                foundLecturer = lecturer;
                break;
            }
        }
    
        if (foundLecturer != null) {
            System.out.println("Courses for Lecturer ID: " + lecturerId);
            for (Course course : foundLecturer.courses) {
                course.displayCourseInfo();
            }
        } else {
            System.out.println("Lecturer not found.");
        }
    }
}