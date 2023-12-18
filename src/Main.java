import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String userName;
    public static List<Question> layers = List.of(
            new Question("Benutzt du einen Laptop oder einen Desktop-PC?",
                    List.of(
                            new Answer("laptop", List.of("laptop", "notebook")),
                            new Answer("desktop", List.of("desktop", "pc", "computer"))
                    ),
                    null),
            new Question("Ist dein Problem mit der Hardware oder der Software verbunden?",
                    List.of(
                            new Answer("hardware", List.of("hardware")),
                            new Answer("software", List.of("software"))
                    ),
                    "laptop"),
            new Question("Ist dein Problem mit der Hardware oder der Software verbunden?",
                    List.of(
                            new Answer("hardware", List.of("hardware")),
                            new Answer("software", List.of("software"))
                    ),
                    "desktop"),
            new Question("Funktioniert das Gerät nicht mehr seit du neue Hardware eingebaut hast?",
                    List.of(
                            new Answer("ja-neue-hardware", Utils.ja), //ende
                            new Answer("nein-neue-hardware", Utils.nein)
                    ),
                    "hardware"),
            new Question("Hat dein Computer ungewöhnliche Geräusche gemacht?",
                    List.of(
                            new Answer("ja-geraeusche", Utils.ja), //ende
                            new Answer("nein-geraeusche", Utils.nein)
                    ),
                    "nein-neue-hardware"),
            new Question("Wird nicht das richtige Bild auf dem Monitor angezeigt, obwohl das angeschlossene Gerät eingeschaltet ist?",
                    List.of(
                            new Answer("monitor", Utils.ja),
                            new Answer("andere-pc-teile", Utils.nein)
                    ),
                    "nein-geraeusche"),
            new Question("Beschreibe dein Problem genauer? Was wird auf dem Monitor angezeigt.",
                    List.of(
                            new Answer("flackern", List.of("flacker")), //ende
                            new Answer("bild-gestoppt", List.of("stop", "standbild")),//ende
                            new Answer("schwarzbild", List.of("dunkel", "schwarz"))//ende
                    ),
                    "monitor"),
            new Question("Weißt du, welches Teil den Fehler verursacht?",
                    List.of(
                            new Answer("fehlerteil-bekannt", Utils.ja),
                            new Answer("fehlerteil-unbekannt", Utils.nein) //ende > hilfe, wie man das fehlerteil findet
                    ),
                    "andere-pc-teile"),
            new Question("Welches Teil verursacht den Fehler?",
                    List.of(
                            new Answer("gpu", List.of("GPU", "Grafik", "Video", "Graphic")), //ende
                            new Answer("cpu", List.of("CPU", "Prozessor", "Processor")),//ende
                            new Answer("psu", List.of("PSU", "Netzteil", "Stromversorg")),//ende
                            new Answer("mainboard", List.of("Mainboard", "Motherboard")),//ende
                            new Answer("luefter", List.of("Lüfter", "Lüftung"))//ende
                    ),
                    "fehlerteil-bekannt"),
            new Question("Verwendest du Windows oder Linux?",
                    List.of(
                            new Answer("linux", List.of("linux")), // ende > kein support
                            new Answer("windows", List.of("windows", "microsoft"))
                    ),
                    "software"),
            new Question("Gibt es Probleme mit dem Betriebssystem?",
                    List.of(
                            new Answer("ja-betriebssystem", Utils.ja),
                            new Answer("nein-betriebssystem", Utils.nein)
                    ),
                    "windows"),
            new Question("Hat das Problem mit einem Softwareupdate zu tun?",
                    List.of(
                            new Answer("updateproblem", Utils.ja), //ende
                            new Answer("kein-updateproblem", Utils.nein)
                    ),
                    "ja-betriebssystem"),
            new Question("Gibt es Probleme beim Wechsel der Windowsversion (z.B. Windows 10 auf Windows 11)?",
                    List.of(
                            new Answer("windows-aktualisierung", Utils.ja), //ende
                            new Answer("nicht-windows-aktualisierung", Utils.nein) //ende
                    ),
                    "kein-updateproblem"),
            new Question("Welche Software verursacht das Problem?",
                    List.of(
                            new Answer("browser", List.of("Chrome", "Firefox", "Browser", "Edge", "Internet Explorer", "Opera")), //ende
                            new Answer("mc-office", List.of("Word", "Excel", "Powerpoint", "Outlook", "365")), //ende
                            new Answer("sicherheit", List.of("Norton", "McAfee", "Kaspersky", "Avira", "Malwarebytes", "Windows Defender")), //ende
                            new Answer("multimedia", List.of("VLC", "Adobe Premiere", "Audacity", "iTunes", "Spotify", "FL Studio")), //ende
                            new Answer("office-tools", List.of("OneNote", "Access", "Google Workspace", "LibreOffice", "WPS Office", "Zoho Office")), //ende
                            new Answer("kommunikation", List.of("Slack", "Teams", "Zoom", "Skype", "Discord")) //ende
                    ),
                    "nein-betriebssystem")
    );
    private static final List<String> prevAnswers = new ArrayList<>();

    public static void main(String[] args) {
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
                    System.out.println("Chatbot: Tschüss! Bis zum nächsten Mal, " + userName + "!");
                    break;
                }
            } else {
                break;
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

            System.out.println("Chatbot: " + "Hat das geholfen?");
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
}