import java.util.ArrayList;

public class DataBase {

    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Professor> professors = new ArrayList<Professor>();
    static ArrayList<Class> classes = new ArrayList<Class>();

    public static boolean isFoundStudentNumber(String studentNumber) {

        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidToLogInStudent(String studentNumber, String password) {

        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber) && student.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void studentsInformationPrinter() {

        for (Student student : students) {

            System.out.println("name: " + student.getName());
            System.out.println("last name: " + student.getLastName());
            System.out.println("student number: " + student.getStudentNumber());
            System.out.println("field: " + student.getField());
            System.out.println("average grade: " + student.getGradeAverage());
            System.out.println("---------------------------------------------");

        }
    }

    public static void numberOfStudents() {

        System.out.println("The number of registered students is: " + students.size());
        System.out.println("---------------------------------------------");
    }

    public static void professorsInformationPrinter() {

        for (Professor professor : professors) {
            System.out.println("name: " + professor.getName());
            System.out.println("last name: " + professor.getLastName());
            System.out.println("professor id: " + professor.getProfessorId());
            System.out.println("password: " + professor.getPassword());
            System.out.println("field: " + professor.getField());
            System.out.println("---------------------------------------------");
        }
    }

    public static void numberOfProfessors() {

        System.out.println("The number of registered students is: " + professors.size());
        System.out.println("---------------------------------------------");
    }

    public static boolean isValidToLogInProfessor(String professorId, String password) {

        for (Professor professor : professors) {
            if (professor.getProfessorId().equals(professorId) && professor.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFoundClassName(String className) {

        for (Class class1 : classes) {
            if (class1.getName().equals(className)) {
                return true;
            }
        }

        return false;
    }

    public static int returnIndexOfClass(String className) {

        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getName().equals(className)) {
                return i;
            }
        }

        return 0;
    }

    public static Student returnStudentByStudentNumber(String studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;
    }


    public static boolean isStudentInClass(Student currentStudent, String classToJoin) {
        for (Class class1 : classes) {
            if (class1.getName().equals(classToJoin)) {
                for (Student student : class1.getStudents()) {
                    if (student.getStudentNumber().equals(currentStudent.getStudentNumber())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Professor returnProfessorByProfessorId(String professorId) {
        for (Professor professor : professors) {
            if (professor.getProfessorId().equals(professorId)) {
                return professor;
            }
        }
        return null;
    }

    public static Class returnClassByClassName(String className) {
        for (Class class1 : classes) {
            if (class1.getName().equals(className)) {
                return class1;
            }
        }
        return null;
    }

    public static boolean isClassFound(String className){
        for (Class class1 : classes) {
            if (class1.getName().equals(className)) {
                return true;
            }
        }
        return false;
    }

    public static int returnIndexOfQuestion(String questionName, String questionText , String className){
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getName().equals(className)) {
                for (int j = 0; j < classes.get(i).getQuestionBank().size(); j++) {
                    if (classes.get(i).getQuestionBank().get(j).getQuestionName().equals(questionName) && classes.get(i).getQuestionBank().get(j).getQuestionText().equals(questionText)) {
                        return j;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isfoundQuestion(String className, String questionName, String questionText) {

        for (Class class1 : classes) {
            if (class1.getName().equals(className)) {
                for (Question question : class1.getQuestionBank()) {
                    if (question.getQuestionName().equals(questionName) && question.getQuestionText().equals(questionText)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }
}
