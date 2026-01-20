import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CartActionReader {

    public List<String> readAllLines(Path inputPath) throws IOException {
        if (inputPath == null) {
            throw new IllegalArgumentException("Input path cannot be null");
        }
        return Files.readAllLines(inputPath);
    }
}
