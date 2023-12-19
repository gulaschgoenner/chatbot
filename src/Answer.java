import java.util.List;

public class Answer {
    private String answer;
    private List<String> keywords;

    public Answer(String answer, List<String> keywords) {
        this.answer = answer;
        this.keywords = keywords;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
