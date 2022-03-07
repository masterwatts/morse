import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Morse {
    public static Map<String, String> alphabet = new LinkedHashMap<String, String>()
    {{
        put("a", ".-");
        put("b", "-...");
        put("c", "-.-.");
        put("d", "-..");
        put("e", ".");
        put("f", "..-.");
        put("g", "--.");
        put("h", "....");
        put("i", "..");
        put("j", ".---");
        put("k", "-.-");
        put("l", ".-..");
        put("m", "--");
        put("n", "-.");
        put("o", "---");
        put("p", ".--.");
        put("q", "--.-");
        put("r", ".-.");
        put("s", "...");
        put("t", "-");
        put("u", "..-");
        put("v", "...-");
        put("w", ".--");
        put("x", "-..-");
        put("y", "-.--");
        put("z", "--..");
        put(" ", "/");
    }};

    public static String toMorse(String str) {
        StringBuilder result = new StringBuilder();
        str = str.toLowerCase(Locale.ROOT);

        char[] characters = str.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            String c = String.valueOf(characters[i]);

            if (alphabet.containsKey(c))
                result.append(alphabet.get(c) + " ");
        }

        return String.valueOf(result);
    }

    public static String reverse(String morse) {
        StringBuilder result = new StringBuilder();
        String[] sequences = morse.split(" ");

        for (int i = 0; i < sequences.length; i++) {
            String str = sequences[i];

            if (alphabet.containsValue(str))
                result.append(alphabet.keySet().stream().filter(s -> alphabet.get(s).equals(str)).collect(Collectors.toList()).stream().findFirst().get());
        }

        return String.valueOf(result);
    }
}
