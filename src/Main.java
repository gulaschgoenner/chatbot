import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String userName;
    public static List<Question> layers = List.of(
            new Question("Handelt es sich um ein Hardware- oder Softwareproblem?",
                    List.of(
                            new Answer("hardware", List.of("hardware")),
                            new Answer("software", List.of("software"))
                    ),
                    null),
            new Question("Verwendest du Windows oder Linux?",
                    List.of(
                            new Answer("linux", List.of("linux")),
                            new Answer("windows", List.of("windows", "microsoft"))
                    ),
                    "software"),
            new Question("Gibt es Probleme mit dem Monitor oder einem anderen Teil?",
                    List.of(
                            new Answer("monitor", List.of("monitor", "bildschirm")),
                            new Answer("anderes-pc-teil", List.of("GPU", "CPU", "andere", "PSU", "Prozessor", "Grafik", "Mainboard", "Motherboard"))
                    ),
                    "hardware"),
            new Question("Raucht es?",
                    List.of(
                            new Answer("rauch-ja", Utils.ja),
                            new Answer("rauch-nein", Utils.nein)
                    ),
                    "anderes-pc-teil"),
            new Question("Beschreibe das Problem deines Bildschirms etwas genauer.",
                    List.of(
                            new Answer("flackern", List.of("flacker")),
                            new Answer("bild-gestoppt", List.of("stop", "standbild")),
                            new Answer("schwarzbild", List.of("dunkel", "schwarz"))
                    ),
                    "monitor"),
            new Question("Bei welcher Software tritt das Problem auf?",
                    List.of(
                            new Answer("browser", List.of("Chrome", "Firefox", "Browser", "Edge", "Internet Explorer", "Opera")),
                            new Answer("mc-office", List.of("Word", "Excel", "Powerpoint", "Outlook", "Office", "365")),
                            new Answer("andere-software", List.of("andere", "keine"))
                    ),
                    "windows")
    );
    private static final List<String> prevAnswers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hallo! Wie lautet dein Name?");
        userName = getUserMessage(scanner);
        System.out.println("Hallo " + userName + "!");

        while (true) {
            askQuestions(scanner);
            getSolutions();
            System.out.println("Hast du ein weiteres Problem?");
            String userResponse = getUserMessage(scanner);

            if (messageContainsFromList(userResponse, Utils.ja)) {
                resetConversation();
            } else {
                System.out.println("Chatbot: Tschüss! Bis zum nächsten Mal, " + userName + "!");
                break;
            }

        }
    }

    private static void getSolutions() {
        // TODO
        System.out.println(prevAnswers);
        System.out.println("Starte das Gerät neu.");
    }

    private static void askQuestions(Scanner scanner) {
        int question = prevAnswers.size();

        while (layers.size() > question) {
            if (checkPrerequisite(layers.get(question).getPrerequisite())) {
                System.out.println("Chatbot: " + layers.get(question).getQuestion());

                if (question < prevAnswers.size()) {
                    question++;
                    continue;
                }

                String userMessage = getUserMessage(scanner);

                while (getAnswer(userMessage, layers.get(question).getAnswers()) == null) {
                    System.out.println("Chatbot: Bitte gib eine genauere Antwort.");
                    userMessage = getUserMessage(scanner);
                }

                prevAnswers.add(getAnswer(userMessage, layers.get(question).getAnswers()));
                question++;
            } else {
                question++;
            }
        }
    }

    private static boolean checkPrerequisite(String prerequisite) {
        if (prerequisite == null || prevAnswers.size() == 0) {
            return true;
        }
        return Objects.equals(prevAnswers.get(prevAnswers.size() - 1), prerequisite);
    }

    private static String getAnswer(String input, List<Answer> answers) {
        if (input == null) {
            return null;
        }
        return answers.stream().filter(answer -> answer.getKeywords().stream().anyMatch(s -> messageContains(input, s))).map(Answer::getAnswer).findFirst().orElse(null);
    }

    private static String getUserMessage(Scanner scanner) {
        String userMessage = "";
        while (userMessage.trim().isEmpty()) {
            System.out.print("Du: ");
            userMessage = scanner.nextLine();
        }

        String finalUserMessage = userMessage;
        if (Utils.verabschiedungen.stream().anyMatch(s -> messageContains(finalUserMessage, s))) {
            System.out.println("Chatbot: Tschüss! Bis zum nächsten Mal, " + userName + "!");
        }
        return userMessage;
    }

    public static boolean messageContains(String msg, String str2) {
        return msg.toLowerCase().trim().contains(str2.trim().toLowerCase());
    }

    private static boolean messageContainsFromList(String userMessage, List<String> keywords) {
        return keywords.stream().anyMatch(kw -> messageContains(userMessage, kw));
    }

    private static void resetConversation() {
        prevAnswers.clear();
    }
}