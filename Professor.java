import javax.swing.JOptionPane;

public class Professor {

    private String name;
    private String lastName;
    private String professorId;
    private String password;
    private String field;

    public Professor(String name, String lastName, String professorId, String password, String field) {
        this.name = name;
        this.lastName = lastName;
        this.professorId = professorId;
        this.password = password;
        this.field = field;
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

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
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

    public static void professorPage() {

        int userInput;

        userInput = Integer.parseInt(
                JOptionPane.showInputDialog(null, "You select professor roll.\nSelect one:\n1.Sign up\n2.Log in",
                        "Professor Page",
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
        String professorId;
        String password;
        String field;
        // double gradeAverage;

        DataBase.professorsInformationPrinter();
        DataBase.numberOfProfessors();

        name = JOptionPane.showInputDialog(null, "Please enter your name and click OK", "Professor Sign up",
                JOptionPane.NO_OPTION);

        lastName = JOptionPane.showInputDialog(null, "Please enter your last name and click OK", "Professor Sign up",
                JOptionPane.NO_OPTION);

        professorId = JOptionPane.showInputDialog(null, "Please enter your professor id and click OK",
                "Professor Sign up", JOptionPane.NO_OPTION);

        password = JOptionPane.showInputDialog(null, "Please enter your password and click OK",
                "Professor Sign up", JOptionPane.NO_OPTION);

        field = JOptionPane.showInputDialog(null, "Please enter your field and click OK", "Professor Sign up",
                JOptionPane.NO_OPTION);

        Professor professor = new Professor(name.toLowerCase(), lastName.toLowerCase(), professorId.toLowerCase(),
                password, field.toLowerCase());

        DataBase.professors.add(professor);

        DataBase.professorsInformationPrinter();
        DataBase.numberOfProfessors();

    }

    public static void logIn() {

        String professorId;
        String password;
        int userInput;

        professorId = JOptionPane.showInputDialog(null, "Please enter your professor id", "Professor Log in",
                JOptionPane.NO_OPTION);

        password = JOptionPane.showInputDialog(null, "Please enter your password", "Professor Log in",
                JOptionPane.NO_OPTION);

        while (DataBase.isValidToLogInProfessor(professorId, password) == false) {

            JOptionPane.showMessageDialog(null,
                    "Either the professor id or the password is incorrect\nclick OK and enter them again",
                    "Professor Log in", JOptionPane.ERROR_MESSAGE);

            professorId = JOptionPane.showInputDialog(null, "Please enter your professor id again",
                    "Professor Log in",
                    JOptionPane.NO_OPTION);

            password = JOptionPane.showInputDialog(null, "Please enter your password again", "Professor Log in",
                    JOptionPane.NO_OPTION);
        }

        JOptionPane.showMessageDialog(null, "The log in was successful!\nclick OK to continue", "Professor Log in",
                JOptionPane.NO_OPTION);

        Professor professor = DataBase.returnProfessorByProfessorId(professorId);

        professorMenu(professor);
    }

    public static void professorMenu(Professor currentProfessor) {

        int userInput;

        userInput = Integer.parseInt(
                JOptionPane.showInputDialog(null, "You select student menu.\nSelect one:\n1.Create new class\n2.Go to a class",
                        "Professor Menu",
                        JOptionPane.NO_OPTION));

        switch (userInput) {
            case 1:
                createNewClass(currentProfessor);
                break;
            case 2:
                goToAClass(currentProfessor);
                break;
        }
    }

    public static void createNewClass(Professor currentProfessor) {

        String className;
        Professor professor;

        className = JOptionPane.showInputDialog(null, "Please enter the name of the class and click OK",
                "Create New Class", JOptionPane.NO_OPTION);

        professor = currentProfessor;

        Class newClass = new Class(className, professor);

        DataBase.classes.add(newClass);
    }

    public static void goToAClass(Professor currentProfessor) {

        String className;

        className = JOptionPane.showInputDialog(null, "Please enter the name of the class and click OK",
                "Go to a Class", JOptionPane.NO_OPTION);

        while (DataBase.isFoundClassName(className) == false) {
            className = JOptionPane.showInputDialog(null, "This class does not exist in the system \n" +
                            "Please enter the name of the class again and click OK",
                    "Go to a Class", JOptionPane.ERROR_MESSAGE);
        }

        if (DataBase.returnClassByClassName(className).getProfessor().equals(currentProfessor) == false) {

            JOptionPane.showMessageDialog(null, "You are not the professor of this class\nclick OK to continue",
                    "Go to a Class", JOptionPane.ERROR_MESSAGE);
        }

        classFunctions(currentProfessor, className);
    }

    public static void classFunctions(Professor currentProfessor, String className) {

        int userInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose one: \n1.Add student to class \n" +
                "2.Remove student from class \n3.Add Home work \n4.Add question to question bank " +
                "\n5.Remove question from question bank "));

        switch (userInput) {

            case 1:
                addStudentToClass(currentProfessor, className);
                break;
            case 2:
                removeStudentFromClass(currentProfessor, className);
                break;
            case 3:
                addHomeWork(currentProfessor, className);
                break;
            case 4:
                addQuestionToQuestionBank(currentProfessor, className);
            case 5:
                removeQuestionFromQuestionBank(currentProfessor, className);
        }
    }

    public static void addStudentToClass(Professor currentProfessor, String className) {

        String studentNumber;

        studentNumber = JOptionPane.showInputDialog(null, "Please enter the student number and click OK",
                "Add Student to Class", JOptionPane.NO_OPTION);

        while (DataBase.isFoundStudentNumber(studentNumber) == false) {
            studentNumber = JOptionPane.showInputDialog(null, "This student does not exist in the system \n" +
                            "Please enter the student number again and click OK",
                    "Add Student to Class", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(className)).getStudents());

        DataBase.classes.get(DataBase.returnIndexOfClass(className)).getStudents().add(DataBase.returnStudentByStudentNumber(studentNumber));

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(className)).getStudents());
    }

    public static void removeStudentFromClass(Professor currentProfessor, String className) {

        String studentNumber;

        studentNumber = JOptionPane.showInputDialog(null, "Please enter the student number and click OK",
                "Remove Student from Class", JOptionPane.NO_OPTION);

        while (DataBase.isFoundStudentNumber(studentNumber) == false) {
            studentNumber = JOptionPane.showInputDialog(null, "This student does not exist in the system \n" +
                            "Please enter the student number again and click OK",
                    "Remove Student from Class", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(className)).getStudents());

        DataBase.classes.get(DataBase.returnIndexOfClass(className)).getStudents().remove(DataBase.returnStudentByStudentNumber(studentNumber));

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(className)).getStudents());
    }

    public static void addHomeWork(Professor currentProfessor, String className) {
        // create it after:
    }

    public static void addQuestionToQuestionBank(Professor currentProfessor, String className) {

        String questionName;
        String questionText;
        String answer;

        questionName = JOptionPane.showInputDialog(null, "Please enter the question name and click OK",
                "Add Question to Question Bank", JOptionPane.NO_OPTION);
        questionText = JOptionPane.showInputDialog(null, "Please enter the question text and click OK",
                "Add Question to Question Bank", JOptionPane.NO_OPTION);
        answer = JOptionPane.showInputDialog(null, "Please enter the answer and click OK",
                "Add Question to Question Bank", JOptionPane.NO_OPTION);

        Question newQuestion = new Question(questionName, questionText, answer);

        DataBase.classes.get(DataBase.returnIndexOfClass(className)).getQuestionBank().add(newQuestion);

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(className)).getQuestionBank());

    }

    public static void removeQuestionFromQuestionBank(Professor currentProfessor, String className) {

        String questionName;
        String questionText;

        questionName = JOptionPane.showInputDialog(null, "Please enter the question name and click OK",
                "Remove Question from Question Bank", JOptionPane.NO_OPTION);
        questionText = JOptionPane.showInputDialog(null, "Please enter the question text and click OK",
                "Remove Question from Question Bank", JOptionPane.NO_OPTION);

        while (DataBase.isfoundQuestion(className, questionName, questionText) == false) {

            JOptionPane.showMessageDialog(null, "This question does not exist in the system \n" +
                    "Please enter the question name and click OK", "Remove Question from Question Bank", JOptionPane.ERROR_MESSAGE);

            questionName = JOptionPane.showInputDialog(null, "This question does not exist in the system \n" +
                            "Please enter the question name again and click OK",
                    "Remove Question from Question Bank", JOptionPane.ERROR_MESSAGE);
            questionText = JOptionPane.showInputDialog(null, "This question does not exist in the system \n" +
                            "Please enter the question text again and click OK",
                    "Remove Question from Question Bank", JOptionPane.ERROR_MESSAGE);
        }

        DataBase.classes.get(DataBase.returnIndexOfClass(className)).getQuestionBank().remove(DataBase.returnIndexOfQuestion(questionName, questionText, className));

        System.out.println(DataBase.classes.get(DataBase.returnIndexOfClass(className)).getQuestionBank());
    }
}
