package inOut.repetitionLetters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class LetterUtil {

    private LetterUtil() {
    }

    public static Map<Character, Long> numberLetters(Path path) {
        Map<Character, Long> letters = null;
        try {
            letters = Files.lines(path)
                    .map(String::toUpperCase)
                    .flatMapToInt(CharSequence::chars)
                    .filter(it -> it >= 'А' && it <= 'Я')
                    .mapToObj(it -> Character.valueOf((char) it))
                    .collect(Collectors.groupingBy(it -> it, Collectors.counting()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return letters;
    }

    public static List<String> convertToList(Map<Character, Long> mapLetter) {
        List<String> list = mapLetter.entrySet().stream()
                .map(it -> it.getKey() + "-" + it.getValue())
                .collect(Collectors.toList());

        return list;
    }
}
