import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CourseRegistrationSystemGUI extends JFrame {
    private JLabel collageNameLabel, courseNameLabel, courseCodeLabel, creditLabel, lecturerNameLabel;
    private JTextField collageNameTextField, courseNameTextField, creditTextField;
    private JComboBox<String> courseCodeComboBox, lecturerNameComboBox;
    private JButton addCollageButton, addCourseButton, addLecturerButton, addStudentButton;
    private JList<String> coursesList, studentsList, lecturersList;
    private DefaultListModel<String> coursesModel, studentsModel, lecturersModel;
    private Collage collage;

    public CourseRegistrationSystemGUI() {
        setTitle("Course Registration System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add components to the north panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(6, 2));

        collageNameLabel = new JLabel("Collage Name:");
        courseNameLabel = new JLabel("Course Name:");
        courseCodeLabel = new JLabel("Course Code:");
        creditLabel = new JLabel("Credit:");
        lecturerNameLabel = new JLabel("Lecturer Name:");

        collageNameTextField = new JTextField(20);
        courseNameTextField = new JTextField(20);
        creditTextField = new JTextField(5);

        String[] courseCodes = {"CS101", "CS102", "CS201", "CS202"};
        courseCodeComboBox = new JComboBox<>(courseCodes);

        lecturersModel = new DefaultListModel<>();
        lecturersList = new JList<>(lecturersModel);

        addCollageButton = new JButton("Add Collage");
        addCourseButton = new JButton("Add Course");
        addLecturerButton = new JButton("Add Lecturer");
        addStudentButton = new JButton("Add Student");

        northPanel.add(collageNameLabel);
        northPanel.add(collageNameTextField);
        northPanel.add(courseNameLabel);
        northPanel.add(courseNameTextField);
        northPanel.add(courseCodeLabel);
        northPanel.add(courseCodeComboBox);
        northPanel.add(creditLabel);
        northPanel.add(creditTextField);
        northPanel.add(lecturerNameLabel);
        northPanel.add(lecturersList);
        northPanel.add(addCollageButton);
        northPanel.add(addCourseButton);
        northPanel.add(addLecturerButton);
        northPanel.add(addStudentButton);

        add(northPanel, BorderLayout.NORTH);

        // Add components to the center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 3));

        coursesModel = new DefaultListModel<>();
        coursesList = new JList<>(coursesModel);

        studentsModel = new DefaultListModel<>();
        studentsList = new JList<>(studentsModel);

        centerPanel.add(coursesList);
        centerPanel.add(studentsList);
        centerPanel.add(lecturersList);

        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners to the buttonsaddCollageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String collageName = collageNameTextField.getText();
                collage = new Collage(collageName);
                collageNameTextField.setText("");
            }
        });

        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameTextField.getText();
                String courseCode = (String) courseCodeComboBox.getSelectedItem();
                int credit = Integer.parseInt(creditTextField.getText());
                Lecturer lecturer = getLecturerByName((String) lecturersList.getSelectedValue());
                Course course = new Course(courseName, courseCode, credit, lecturer);
                collage.addCourse(course);
                coursesModel.addElement(course.toString());
                courseNameTextField.setText("");
                creditTextField.setText("");
            }
        });

        addLecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lecturerName = (String) lecturersList.getSelectedValue();
                Lecturer lecturer = new Lecturer(lecturerName);
                collage.addLecturer(lecturer);
                lecturersModel.addElement(lecturer.toString());
                lecturersList.setSelectedIndex(lecturersModel.size() - 1);
            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = (String) lecturersList.getSelectedValue();
                Student student = new Student(studentName);
                collage.addStudent(student);
                studentsModel.addElement(student.toString());
                studentsList.setSelectedIndex(studentsModel.size() - 1);
            }
        });

        setVisible(true);
    }

    private Lecturer getLecturerByName(String name) {
        for (Lecturer lecturer : collage.getLecturers()) {
            if (lecturer.getName().equals(name)) {
                return lecturer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new CourseRegistrationSystemGUI();
    }