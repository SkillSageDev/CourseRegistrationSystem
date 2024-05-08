import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collage collage = new Collage("ABC University", "New York");
        RegistrationSystem registrationSystem = new RegistrationSystem(collage);

        while (true) {
            System.out.println("\nCourse Registration System Menu:");
            System.out.println("1. Register Student");
            System.out.println("2. Register Lecturer");
            System.out.println("3. Register Course");
            System.out.println("4. Register Course for Student");
            System.out.println("5. Register Course for Lecturer");
            System.out.println("6. Display College Information");
            System.out.println("7. Display Courses");
            System.out.println("8. Display Students");
            System.out.println("9. Display Lecturers");
            System.out.println("10. Display Courses for Student");
            System.out.println("11. Display Courses for Lecturer");
            System.out.println("12. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationSystem.registerStudent();
                    break;
              case 2:
                    registrationSystem.registerLecturer();
                    break;
                case 3:
                    registrationSystem.registerCourse();
                    break;
                case 4:
                    registrationSystem.registerCourseForStudent();
                    break;
                case 5:
                    registrationSystem.registerCourseForLecturer();
                    break;
                case 6:
                    registrationSystem.displayCollageInfo();
                    break;
                case 7:
                    registrationSystem.displayCourses();
                    break;
                case 8:
                    registrationSystem.displayStudents();
                    break;
                case 9:
                    registrationSystem.displayLecturers();
                    break;
                case 10:
                    registrationSystem.displayCoursesForStudent();
                    break;
                case 11:
                    registrationSystem.displayCoursesForLecturer();
                    break;
                case 12:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}