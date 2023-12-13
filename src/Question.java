import java.util.List;

public class Question {
    private String question;
    private List<Answer> answers;

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    private String prerequisite;

    public Question(String question, List<Answer> answers, String prerequesite) {
        this.question = question;
        this.answers = answers;
        this.prerequisite = prerequesite;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
