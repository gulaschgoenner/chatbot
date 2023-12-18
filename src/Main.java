import java.util.*;

public class Main {
    private static String userName;

    private static final List<String> prevAnswers = new ArrayList<>();

    public static void main(String[] args) {
        validateTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hallo! Wie lautet dein Name?");
        userName = getUserMessage(scanner);
        System.out.println("Hallo " + userName + "!");

        while (true) {
            askQuestions(scanner);
            boolean problemSolved = getSolutions(scanner);

            if (problemSolved) {
                System.out.println("Chatbot: Benötigst du weitere Hilfe?");
                String userResponse = getUserMessage(scanner);
                if (messageContainsFromList(userResponse, Utils.ja)) {
                    resetConversation();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Chatbot: Tschüss! Bis zum nächsten Mal, " + userName + "!");
    }

    private static void askQuestions(Scanner scanner) {
        int question = prevAnswers.size();

        while (Utils.tree.size() > question) {
            if (checkPrerequisite(Utils.tree.get(question).getPrerequisite())) {
                System.out.println("Chatbot: " + Utils.tree.get(question).getQuestion());

                if (question < prevAnswers.size()) {
                    question++;
                    continue;
                }

                String userMessage = getUserMessage(scanner);

                while (getAnswer(userMessage, Utils.tree.get(question).getAnswers()) == null) {
                    System.out.println("Chatbot: Bitte gib eine genauere Antwort.");
                    userMessage = getUserMessage(scanner);
                }

                prevAnswers.add(getAnswer(userMessage, Utils.tree.get(question).getAnswers()));
                question++;
            } else {
                question++;
            }
        }
    }

    private static boolean getSolutions(Scanner scanner) {
        if (userName.contains("debug") || userName.contains("obama")) {
            System.out.println(prevAnswers);
        }
        String lastAnswer = prevAnswers.get(prevAnswers.size() - 1);
        List<String> solutions = Utils.solutions.get(lastAnswer);

        if (solutions == null) {
            System.out.println("Chatbot: Ich konnte leider keine spezifische Lösung finden, hier sind einige allgemeine Hilfen.");
            solutions = Utils.standardSolution;
        } else {
            System.out.println("Chatbot: Ich habe einige Lösungsansätze für dein Problem gefunden.");
        }

        // Lösungen zurückgeben
        boolean fehlerBehoben = false;
        for (String solution : solutions) {
            System.out.println("Chatbot: " + solution);

            System.out.println("Chatbot: " + weitereHilfeNoetigAbfrage());
            String weitereHilfeNoetig = getUserMessage(scanner);
            if (messageContainsFromList(weitereHilfeNoetig, Utils.ja)) {
                fehlerBehoben = true;
                break;
            }
        }

        // Falls nötig Telefonnr als weitere Hilfe anbieten
        if (!fehlerBehoben) {
            System.out.println("Chatbot: Unter dieser Nummer erreichst du unseren Service und kannst unsere professionelle Hilfe beanspruchen: 0521 16391643");
        }
        return fehlerBehoben;
    }

    private static boolean checkPrerequisite(String prerequisite) {
        if (prerequisite == null || prevAnswers.isEmpty()) {
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

    private static void validateTree() {
        List<String> prerequisites = Utils.tree.stream().map(Question::getPrerequisite).toList();
        Set<String> uniqueLinks = new HashSet<>(prerequisites);
        if (uniqueLinks.size() != prerequisites.size()) {
            throw new RuntimeException("Antwortbaum enthält Dopplungen");
        }
        uniqueLinks.remove(null);
        if (uniqueLinks.containsAll(Utils.solutions.keySet())) {
            throw new RuntimeException("Lösungsschlüssel nicht gefunden");
        }
    }

    private static String weitereHilfeNoetigAbfrage() {
        return Utils.weitereHilfeNoetig.get(new Random().nextInt(Utils.weitereHilfeNoetig.size()));
    }
}