/**
 * Created by chris on 2/9/16.
 */
public class QuizQuestion {
    private String term;
    private String definition;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;

    }

    public QuizQuestion(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
