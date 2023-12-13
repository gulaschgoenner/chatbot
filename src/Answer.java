import java.util.List;

public class Answer {
    private String answer;
    private List<String> keywords;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Answer(String answer, List<String> keywords) {
        this.answer = answer;
        this.keywords = keywords;
    }
}
