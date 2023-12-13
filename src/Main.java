import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String userName;
    public static List<Question> layers = List.of(
            new Question("Handelt es sich um ein Hardware- oder Softwareproblem?",
                    List.of(
                            new Answer("hardware", List.of("hardware")),
                            new Answer("software", List.of("software"))
                    )),
            new Question("Verwendest du Windows oder Linux?",
                    List.of(
                            new Answer("linux", List.of("linux")),
                            new Answer("windows", List.of("windows"))
                    )));
    private static List<String> prevAnswers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hallo! Wie lautet dein Name?");
        userName = getUserMessage(scanner);
        System.out.println("Hallo " + userName + "!");

        while (true) {
            respond(scanner);
        }
    }

    private static void getSolutions() {
        System.out.println(prevAnswers);
        // Implement the logic to return solutions based on prevAnswers
    }

    private static void respond(Scanner scanner) {
        int layer = prevAnswers.size();

        while (layers.size() > layer) {
            System.out.println("Chatbot: " + layers.get(layer).getQuestion());

            // Check if the current layer has been answered
            if (layer < prevAnswers.size()) {
                layer++;
                continue;  // Skip to the next layer
            }

            String userMessage = getUserMessage(scanner);

            while (getAnswer(userMessage, layers.get(layer).getAnswers()) == null) {
                System.out.println("Chatbot: Bitte gib eine genauere Antwort.");
                userMessage = getUserMessage(scanner);
            }

            prevAnswers.add(getAnswer(userMessage, layers.get(layer).getAnswers()));
            layer++;
        }

        if (layers.size() <= prevAnswers.size()) {
            getSolutions();
            System.exit(0);  // Terminate the program after providing solutions
        }
    }

    private static String getAnswer(String input, List<Answer> answers) {
        if (input == null) {
            return null;
        }
        return answers.stream().filter(answer -> answer.getKeywords().stream().anyMatch(s -> Utils.messageContains(input, s))).map(Answer::getAnswer).findFirst().orElse(null);
    }

    private static String getUserMessage(Scanner scanner) {
        String userMessage = "";
        while (userMessage.trim().isEmpty()) {
            System.out.print("Du: ");
            userMessage = scanner.nextLine();
        }

        String finalUserMessage = userMessage;
        if (Utils.verabschiedungen.stream().anyMatch(s -> Utils.messageContains(s, finalUserMessage))) {
            System.out.println("Chatbot: Tschüss! Bis zum nächsten Mal, " + userName + "!");
        }
        return userMessage;
    }

    private static void respondToUser(String userMessage) {
        userMessage = userMessage.trim();
        if (Utils.messageContains(userMessage, "hallo")) {
            System.out.println("Chatbot: Hallo! Wie geht es dir?");
        } else if (Utils.messageContains(userMessage, "gut")) {
            System.out.println("Chatbot: Das freut mich zu hören!");
        } else if (Utils.messageContains(userMessage, "schlecht")) {
            System.out.println("Chatbot: Das tut mir leid. Was kann ich für dich tun?");
        } else if (Utils.messageContains(userMessage, "Wetter")) {
            System.out.println("Chatbot: Das Wetter ist heute schön!");
        } else {
            System.out.println("Chatbot: Entschuldigung, ich habe dich nicht verstanden. Kannst du das bitte wiederholen?");
        }
    }
}