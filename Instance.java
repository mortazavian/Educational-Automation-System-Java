public class Instance {

    // Create instance for system
    public static void instanceCreator() {
        //----------------------------------------------------------------------------------------------------------------------
        HomeWork homeWork1 = new HomeWork("homeWork1");
        //----------------------------------------------------------------------------------------------------------------------
        Exam exam1 = new Exam("exam1", 2);
        //----------------------------------------------------------------------------------------------------------------------
        Question question1 = new Question("question1", "question1", "answer1");
        Question question2 = new Question("question2", "question2", "answer2");
        Question question3 = new Question("question3", "question3", "answer3");
        Question question4 = new Question("question4", "question4", "answer4");
        Question question5 = new Question("question5", "question5", "answer5");
        Question question6 = new Question("question6", "question6", "answer6");
        Question question7 = new Question("question7", "question7", "answer7");
        Question question8 = new Question("question8", "question8", "answer8");
        //----------------------------------------------------------------------------------------------------------------------
        Professor professor1 = new Professor("ali", "hamze", "hamze", "ali123", "artificial intelligence");
        Professor professor2 = new Professor("zohre", "azimifar", "zohre_az", "azimifar123", "artificial intelligence");
        Professor professor3 = new Professor("farshad", "khonjosh", "khun", "Farshad123", "hardware");
        Professor professor4 = new Professor("korosh", "ziyarati", "korosh123", "123", "software");
        DataBase.professors.add(professor1);
        DataBase.professors.add(professor2);
        DataBase.professors.add(professor3);
        DataBase.professors.add(professor4);
        //----------------------------------------------------------------------------------------------------------------------
        Student student1 = new Student("mehdi", "mortazavian", "9932114", "mehdi123", "computer engineering", 15.5);
        Student student2 = new Student("ali", "maher", "9932113", "ali123", "computer engineering", 17.54);
        Student student3 = new Student("mohammad", "zahmatkesh", "9932118", "mohsen123", "computer engineering", 12);
        Student student4 = new Student("ali", "ahmadi", "9811441", "ali1234", "electrical engineer", 19);
        DataBase.students.add(student1);
        DataBase.students.add(student2);
        DataBase.students.add(student3);
        DataBase.students.add(student4);
        //----------------------------------------------------------------------------------------------------------------------
        exam1.getScores().put(student1.getStudentNumber(), 15.5);
        Class class1 = new Class("c1", professor1);
        Class class2 = new Class("c2", professor2);
        Class class3 = new Class("c3", professor3);
        Class class4 = new Class("c4", professor4);
        class1.getStudents().add(student1);
        class1.getStudents().add(student2);
        class1.getStudents().add(student3);
        class1.getReferences().add("The C programming language");
        class1.getReferences().add("Java programming language");
        class1.getQuestionBank().add(question1);
        class1.getQuestionBank().add(question2);
        class1.getQuestionBank().add(question3);
        class1.getQuestionBank().add(question4);
        class1.getQuestionBank().add(question5);
        class1.getQuestionBank().add(question6);
        class1.getQuestionBank().add(question7);
        class1.getQuestionBank().add(question8);
        homeWork1.getQuestions().add(question1);
        homeWork1.getQuestions().add(question2);
        homeWork1.getScores().put(student1.getStudentNumber(), 18.75);
        class1.getHomeWorks().add(homeWork1);
        class1.getExams().add(exam1);
        class1.getAnnouncements().add("Tomorrow you will have quiz");
        class1.getAnnouncements().add("Next friday there is a class for English");
        class1.getAnnouncements().add("Next saturday there is a class for computer engineering");
        DataBase.classes.add(class1);
        DataBase.classes.add(class2);
        DataBase.classes.add(class3);
        DataBase.classes.add(class4);

    }

}