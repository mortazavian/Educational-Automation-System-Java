import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HomeWork {

    private String homeWorkName;
    private ArrayList<Question> questions = new ArrayList<Question>();

    private HashMap<String , String> answers = new HashMap<String , String>();

    private HashMap<String , Double> scores = new HashMap<String , Double>();


    public HomeWork(String homeWorkName) {
        this.homeWorkName = homeWorkName;

    }

    public HashMap<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<String, String> answers) {
        this.answers = answers;
    }

    public HashMap<String, Double> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Double> scores) {
        this.scores = scores;
    }

    public String getHomeWorkName() {
        return homeWorkName;
    }

    public void setHomeWorkName(String homeWorkName) {
        this.homeWorkName = homeWorkName;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

}
