package inOut.sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class UtilFile {

    private UtilFile() {
    }

    public static List<String> fillingNumber() {
        List<String> list = null;
        Random random = new Random();

        list = Stream.generate(() -> random.nextInt(100))
                .limit(100)
                .map(String::valueOf)
                .collect(Collectors.toList());

        return list;
    }

    public static void sortNumber(Path path) {
        List<String> list = null;

        try {
            list = Files.lines(path)
                    .map(Integer::valueOf)
                    .sorted(Integer::compareTo)
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            Files.write(path, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
