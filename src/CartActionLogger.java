import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CartActionLogger {

    public void append(Path outputPath, String message) throws IOException {
        if (outputPath == null) {
            throw new IllegalArgumentException("Output path cannot be null");
        }
        if (message == null) {
            message = "";
        }

        Files.writeString(
                outputPath,
                message + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}
