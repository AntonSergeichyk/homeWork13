package inOut.sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NumberSorting {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("resources", "hw2", "number.txt");

        Files.write(path, UtilFile.fillingNumber());
        UtilFile.sortNumber(path);
    }
}
