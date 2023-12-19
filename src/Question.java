import java.util.List;

public class Question {
    private String question;
    private List<Answer> answers;
    private String prerequisite;

    public Question(String question, List<Answer> answers, String prerequesite) {
        this.question = question;
        this.answers = answers;
        this.prerequisite = prerequesite;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
