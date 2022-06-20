import java.util.ArrayList;
import java.util.HashMap;

public class Exam {

    private String examName;

    private int numberOfQuestionsForEachStudent;

    private ArrayList<Question> questions = new ArrayList<Question>();

    private HashMap<String , Double> scores = new HashMap<String , Double>();

    private HashMap<String , String> answers = new HashMap<String , String>();

    private boolean isActive;

    public Exam(String examName, int numberOfQuestionsForEachStudent , boolean isActive) {
        this.examName = examName;
        this.numberOfQuestionsForEachStudent = numberOfQuestionsForEachStudent;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public HashMap<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<String, String> answers) {
        this.answers = answers;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public HashMap<String, Double> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Double> scores) {
        this.scores = scores;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getNumberOfQuestionsForEachStudent() {
        return numberOfQuestionsForEachStudent;
    }

    public void setNumberOfQuestionsForEachStudent(int numberOfQuestionsForEachStudent) {
        this.numberOfQuestionsForEachStudent = numberOfQuestionsForEachStudent;
    }
}
