import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 2/9/16.
 */
public class QuestionSet {
    private String name;
    private String author;

    private List<QuizQuestion> questions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;

    }

    public QuestionSet(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
