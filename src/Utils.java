import java.util.*;

public class Utils {
    public static List<String> verabschiedungen = List.of("tschüss", "bye", "wiedersehen");

    public static boolean messageContains(String str1, String str2) {
        return str2.toLowerCase().trim().contains(str1.trim().toLowerCase());
    }

    public static List<Question> layers = List.of(
            new Question("Handelt es sich um ein Hardware- oder Softwareproblem?",
                    List.of(
                            new Answer("hardware", List.of("hardware")),
                            new Answer("software", List.of("software"))
                    )));
}