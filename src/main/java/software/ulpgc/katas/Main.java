package software.ulpgc.katas;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main() throws IOException {
        File file = new File("document.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());
        System.out.println(file.canRead());

        try (InputStream is = new FileInputStream(file)) {
            System.out.println(new String(is.readAllBytes()));
        }
    }
}
