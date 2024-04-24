import codec.Format;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *
     * Note to the interviewers: the main entry point of this framework is currently {@link GoldenTestRunner}.
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */
    public static void main(String[] args) {
        // TODO: implement code to crawl all files in input.
        // TODO: don't use absolute path.
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test1.md";
        try {
            Converter.convert(filePath, Format.MARKDOWN, Format.HTML);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException when processing file {}: {}", new Object[]{filePath, e});
        }
    }
}