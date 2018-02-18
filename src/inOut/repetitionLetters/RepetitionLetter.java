package inOut.repetitionLetters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class RepetitionLetter {

    public static void main(String[] args) throws IOException {
        Path readPath = Paths.get("resources", "hw1", "Pushkin.txt");
        Path writePath = Paths.get("resources", "hw1", "result.txt");

        Map<Character, Long> mapLetter = LetterUtil.numberLetters(readPath);
        Files.write(writePath,LetterUtil.convertToList(mapLetter));
    }
}
