import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Student {

    private String name;
    private String lastName;
    private String studentNumber;
    private String password;
    private String field;
    private double gradeAverage;
    private ArrayList<Class> classes = new ArrayList<Class>();

    public Student(String name, String lastName, String studentNumber, String password, String field,
                   double gradeAverage) {
        this.name = name;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.password = password;
        this.field = field;
        this.gradeAverage = gradeAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAvrage) {
        this.gradeAverage = gradeAvrage;
    }

    public static void studentPage() {

        int userInput;

        userInput = Integer.parseInt(
                JOptionPane.showInputDialog(null, "You select student roll.\nSelect one:\n1.Sign up\n2.Log in",
                        "Student Page",
                        JOptionPane.NO_OPTION));

        switch (userInput) {
            case 1:
                signUp();
                break;

            case 2:
                logIn();
                break;

            default:
                break;
        }

    }

    // The function to sign up new student
    public static void signUp() {

        String name;
        String lastName;
        String studentNumber;
        String password;
        String field;
        double gradeAverage;

        DataBase.studentsInformationPrinter();
        DataBase.numberOfStudents();

        name = JOptionPane.showInputDialog(null, "Please enter your name and click OK", "Student Sign up",
                JOptionPane.NO_OPTION);

        lastName = JOptionPane.showInputDialog(null, "Please enter your last name and click OK", "Student Sign up",
                JOptionPane.NO_OPTION);

        studentNumber = JOptionPane.showInputDialog(null, "Please enter your student number and click OK",
                "Student Sign up", JOptionPane.NO_OPTION);

        password = JOptionPane.showInputDialog(null, "Please enter your password and click OK",
                "Student Sign up", JOptionPane.NO_OPTION);

        field = JOptionPane.showInputDialog(null, "Please enter your field and click OK", "Student Sign up",
                JOptionPane.NO_OPTION);

        gradeAverage = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Please enter your average grade and click OK", "Student Sign up", JOptionPane.NO_OPTION));

        Student student = new Student(name.toLowerCase(), lastName.toLowerCase(), studentNumber, password,
                field.toLowerCase(), gradeAverage);

        DataBase.students.add(student);

        DataBase.studentsInformationPrinter();
        DataBase.numberOfStudents();

    }

    public static void logIn() {

        String studentNumber;
        String password;

        studentNumber = JOptionPane.showInputDialog(null, "Please enter your student number", "Student Log in",
                JOptionPane.NO_OPTION);

        password = JOptionPane.showInputDialog(null, "Please enter your password", "Student Log in",
                JOptionPane.NO_OPTION);

        while (DataBase.isValidToLogInStudent(studentNumber, password) == false) {

            JOptionPane.showMessageDialog(null,
                    "Either the student number or the password is incorrect\nclick OK and enter them again",
                    "Student Log in", JOptionPane.ERROR_MESSAGE);

            studentNumber = JOptionPane.showInputDialog(null, "Please enter your student number again",
                    "Student Log in",
                    JOptionPane.NO_OPTION);

            password = JOptionPane.showInputDialog(null, "Please enter your password again", "Student Log in",
                    JOptionPane.NO_OPTION);
        }

        JOptionPane.showMessageDialog(null, "The log in was successful!\nclick OK to continue", "Student Log in",
                JOptionPane.NO_OPTION);

        Student currentStudent = DataBase.returnStudentByStudentNumber(studentNumber);

        studentMenu(currentStudent);

    }

    public static void studentMenu(Student currentStudent) {

        int userInput;

        userInput = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "You select student menu.\nSelect one:\n1.Join a class\n2.Go to a class",
                        "Student Menu",
                        JOptionPane.NO_OPTION));

        switch (userInput) {
            case 1:
                joinClassStudent(currentStudent);
                break;
            case 2:
                goToClassStudent(currentStudent);
                break;

        }
    }

    public static void joinClassStudent(Student currentStudent) {

        String classToJoin = JOptionPane.showInputDialog(null, "Please enter the name of the class you want to join: ",
                "Join a class", JOptionPane.NO_OPTION);

        while (DataBase.isFoundClassName(classToJoin) == false) {
            JOptionPane.showMessageDialog(null, "The class name is incorrect\nclick OK and enter it again",
                    "Join a class", JOptionPane.ERROR_MESSAGE);
            classToJoin = JOptionPane.showInputDialog(null, "Please enter the name of the class you want to join: ",
                    "Join a class", JOptionPane.NO_OPTION);
        }

        // Check if the student is already in the class
        if (DataBase.isStudentInClass(currentStudent, classToJoin) == true) {
            JOptionPane.showMessageDialog(null, "You are already in the class", "Join a class",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Class tempClass = DataBase.classes.get(DataBase.returnIndexOfClass(classToJoin));

//            for (int i=0;i)




            DataBase.classes.get(DataBase.returnIndexOfClass(classToJoin)).getStudents().add(currentStudent);
        }




    }

    private static void goToClassStudent(Student currentStudent) {

        String classToGoTo = JOptionPane.showInputDialog(null, "Please enter the name of the class you want to go to: ",
                "Go to a class", JOptionPane.NO_OPTION);

        while (DataBase.isFoundClassName(classToGoTo) == false) {
            JOptionPane.showMessageDialog(null, "The class name is incorrect\nclick OK and enter it again",
                    "Go to a class", JOptionPane.ERROR_MESSAGE);
            classToGoTo = JOptionPane.showInputDialog(null, "Please enter the name of the class you want to go: ",
                    "Go to a class", JOptionPane.NO_OPTION);
        }

        if (DataBase.isStudentInClass(currentStudent, classToGoTo) == true) {

            int userInput = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "You select class menu.\nSelect one:\n1.View students in the class\n2.View the references\n" +
                            "3.Go to exams \n4.Go to home works \n" +
                            "5.See an exam grade \n6.See a home work grade \n" +
                            "7.See announcements",
                    "Go to a class", JOptionPane.NO_OPTION));

            switch (userInput) {
                case 1:
                    viewClassStudent(currentStudent, classToGoTo);
                    break;
                case 2:
                    viewClassReferences(currentStudent, classToGoTo);
                    break;
                case 3:
                    examPage(currentStudent, classToGoTo);
                    break;
                case 4:
                    homeWorkPage(currentStudent, classToGoTo);
                    break;
                case 5:
                    seeExamGrade(currentStudent, classToGoTo);
                    break;
                case 6:
                    seeHomeWorkGrade(currentStudent, classToGoTo);
                    break;
                case 7:
                    seeAnnouncements(currentStudent, classToGoTo);
                    break;

            }

        } else {
            JOptionPane.showMessageDialog(null, "You are not a student in this class", "Go to a class",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private static void viewClassStudent(Student currentStudent, String classToGoTo) {

        String studentsName = "The students in the class are: \n";

        for (Student student : DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getStudents()) {
            studentsName += student.getName() + " " + student.getLastName() + "\n";
            // System.out.println(student.name + " " + student.lastName);
        }

        JOptionPane.showMessageDialog(null, studentsName, "Students in class", JOptionPane.NO_OPTION);
    }

    private static void viewClassReferences(Student currentStudent, String classToGoTo) {
        for (Class class1 : DataBase.classes) {
            if (class1.getName().equals(classToGoTo)) {
                for (String reference : class1.getReferences()) {
                    System.out.println(reference);
                }
            }
        }
    }

    private static void examPage(Student currentStudent, String classToGoTo) {

        Random random = new Random();

        String allQuestions = "The questions are:\n";
        String studentAnswer;
        String examName = JOptionPane.showInputDialog(null, "Please enter the name of the exam: ", "Exam page", JOptionPane.NO_OPTION);

        while (DataBase.returnIndexOfExam(classToGoTo, examName) == -1) {

            examName = JOptionPane.showInputDialog(null, "Please enter the name of the exam: ", "Exam page", JOptionPane.NO_OPTION);
        }

        Exam exam = DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getExams().get(DataBase.returnIndexOfExam(classToGoTo, examName));

        if (exam.isActive() == true) {

            ArrayList<Integer> askedQuestions = new ArrayList<Integer>();

            askedQuestions.add(0);

            System.out.println(exam.getNumberOfQuestionsForEachStudent());

            for (int i = 0; i < exam.getNumberOfQuestionsForEachStudent(); i++) {

                int randomQuestion = random.nextInt(DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getQuestionBank().size());

                while (askedQuestions.contains(randomQuestion)) {
                    randomQuestion = random.nextInt(DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getQuestionBank().size());
                }

                allQuestions += DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getQuestionBank().get(randomQuestion).getQuestionText() + "\n";

                askedQuestions.add(randomQuestion);

            }

            studentAnswer = JOptionPane.showInputDialog(null, allQuestions + "\nEnter your answers and then click OK", "Exam page", JOptionPane.NO_OPTION);

            DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getExams().get(DataBase.returnIndexOfExam(classToGoTo, examName)).getAnswers().put(currentStudent.getStudentNumber(), studentAnswer);

            System.out.println(allQuestions);

            System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getExams().get(DataBase.returnIndexOfExam(classToGoTo, examName)).getAnswers());

        }
        else if (exam.isActive() == false) {
            JOptionPane.showMessageDialog(null, "The exam is not active", "Exam page", JOptionPane.ERROR_MESSAGE);
        }


    }

    private static void homeWorkPage(Student currentStudent, String classToGoTo) {

        String studentAnswer;
        String homeWorkName = JOptionPane.showInputDialog(null, "Please enter the name of the home work: ", "Home work page", JOptionPane.NO_OPTION);
        String allQuestions = "The questions are:\n";
        while (DataBase.returnIndexOfHomeWork(classToGoTo, homeWorkName) == -1) {

            homeWorkName = JOptionPane.showInputDialog(null, "Please enter the name of the home work: ", "Home work page", JOptionPane.NO_OPTION);
        }

        HomeWork homeWork = DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getHomeWorks().get(DataBase.returnIndexOfHomeWork(classToGoTo, homeWorkName));

        for (int i = 0; i < homeWork.getQuestions().size(); i++) {
            allQuestions += homeWork.getQuestions().get(i).getQuestionText() + "\n";
        }

        studentAnswer = JOptionPane.showInputDialog(null, allQuestions + "\nEnter your answers and then click OK", "Home work page", JOptionPane.NO_OPTION);

        System.out.println(studentAnswer);

        DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getHomeWorks().get(DataBase.returnIndexOfHomeWork(classToGoTo, homeWorkName)).getAnswers().put(currentStudent.getStudentNumber(), studentAnswer);

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getHomeWorks().get(DataBase.returnIndexOfHomeWork(classToGoTo, homeWorkName)).getAnswers());
    }

    public static void seeExamGrade(Student currentStudent, String classToGoTo) {

        String examName = JOptionPane.showInputDialog(null, "Please enter the name of the exam: ", "Exam page", JOptionPane.NO_OPTION);
        double studentGrade;

        while (DataBase.returnIndexOfExam(classToGoTo, examName) == -1) {

            examName = JOptionPane.showInputDialog(null, "Please enter the name of the exam: ", "Exam page", JOptionPane.NO_OPTION);
        }

        Exam exam = DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getExams().get(DataBase.returnIndexOfExam(classToGoTo, examName));

        if (exam.getScores().get(currentStudent.getStudentNumber()) == null) {
            JOptionPane.showMessageDialog(null, "You have not taken this exam yet", "Exam page", JOptionPane.ERROR_MESSAGE);
        }
        if (exam.getScores().get(currentStudent.getStudentNumber()) != null) {
            studentGrade = exam.getScores().get(currentStudent.getStudentNumber());
            JOptionPane.showMessageDialog(null, "Your grade is: " + studentGrade, "Exam page", JOptionPane.NO_OPTION);
        }
    }

    public static void seeHomeWorkGrade(Student currentStudent, String classToGoTo) {

        String homeWorkName = JOptionPane.showInputDialog(null, "Please enter the name of the home work: ", "Home work page", JOptionPane.NO_OPTION);
        double studentGrade;

        while (DataBase.returnIndexOfHomeWork(classToGoTo, homeWorkName) == -1) {

            homeWorkName = JOptionPane.showInputDialog(null, "Please enter the name of the home work: ", "Home work page", JOptionPane.NO_OPTION);
        }

        HomeWork homeWork = DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getHomeWorks().get(DataBase.returnIndexOfHomeWork(classToGoTo, homeWorkName));

        if (homeWork.getScores().get(currentStudent.getStudentNumber()) == null) {
            JOptionPane.showMessageDialog(null, "You have not taken this home work yet", "Home work page", JOptionPane.ERROR_MESSAGE);
        }
        if (homeWork.getScores().get(currentStudent.getStudentNumber()) != null) {
            studentGrade = homeWork.getScores().get(currentStudent.getStudentNumber());
            JOptionPane.showMessageDialog(null, "Your grade is: " + studentGrade, "Home work page", JOptionPane.NO_OPTION);
        }
    }

    public static void seeAnnouncements(Student currentStudent, String classToGoTo) {
        String announcements = "The announcements are: \n";
        for (int i = 0; i < DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getAnnouncements().size(); i++) {
            announcements += DataBase.classes.get(DataBase.returnIndexOfClass(classToGoTo)).getAnnouncements().get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, announcements, "Announcements", JOptionPane.NO_OPTION);
    }
}
