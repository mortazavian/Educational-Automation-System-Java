import java.util.ArrayList;

public class Class {


    private String name;
    private ArrayList <Student> students = new ArrayList<Student>();
    private ArrayList<String> references = new ArrayList<String>();
    private Professor professor;    // professor who teaches this class

    private ArrayList<Question> questionBank = new ArrayList<Question>();

    public Class(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
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
