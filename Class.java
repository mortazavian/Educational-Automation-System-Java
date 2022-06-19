import java.util.ArrayList;

public class Class {


    private String name;
    private ArrayList <Student> students = new ArrayList<Student>();
    private ArrayList<String> references = new ArrayList<String>();
    private Professor professor;    // professor who teaches this class

    private ArrayList<Question> questionBank = new ArrayList<Question>();

    private ArrayList<Exam> exams = new ArrayList<Exam>();

    private ArrayList<HomeWork> homeWorks = new ArrayList<HomeWork>();

    private ArrayList<String> announcements = new ArrayList<String>();

    public Class(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
    }

    public ArrayList<String> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(ArrayList<String> announcements) {
        this.announcements = announcements;
    }

    public ArrayList<HomeWork> getHomeWorks() {
        return homeWorks;
    }

    public void setHomeWorks(ArrayList<HomeWork> homeWorks) {
        this.homeWorks = homeWorks;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<String> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<String> references) {
        this.references = references;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Question> getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(ArrayList<Question> questionBank) {
        this.questionBank = questionBank;
    }
}
