import javax.swing.JOptionPane;

// Educational Automation System
// Mehdi Mortazavian 9932114

public class Main {

    public static void main(String[] args) {

        System.out.println("HI");

        Student student = new Student("mehdi", "mortazavian", "99923", "mehdi123 ", "computer", 99);

        Professor professor = new Professor("ali", "mami", "morti", "java", "computer science");

//        Quiz.questions.add(student);
//        Quiz.questions.add(professor);
//
//        System.out.println(Quiz.questions.get(0));
//        System.out.println(Quiz.questions.get(1));

        // Create instance of professor class and student class
        Instance.instanceCreator();

        int userInput;

        JOptionPane.showMessageDialog(null, "Welcome to Educational Automation System", "Welcome",
                JOptionPane.NO_OPTION);

        userInput = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Choose your roll:\n1.student\n2.professor", "Select Roll",
                        JOptionPane.NO_OPTION));

        System.out.println(userInput);

        switch (userInput) {
            case 1:
                Student.studentPage();
                break;

            case 2:
                Professor.professorPage();
                break;

            default:
                break;
        }

        // test faze 1
//        System.out.println(DataBase.classes.get(0).students.get(0).getStudentNumber());
//        System.out.println(DataBase.classes.get(0).references.get(0));



    }

}

// Create new class by professor
// See students in class by student
