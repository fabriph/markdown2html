
import codec.Format;

import org.junit.jupiter.api.Test;
//import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoldenTestRunner {
    private static final Logger LOGGER = Logger.getLogger(GoldenTestRunner.class.getName());

    // TODO: no need for each individual file to be its own test.

    @Test
    void test1() throws IOException {
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test1.md";
        Converter.convert(filePath, Format.MARKDOWN, Format.HTML);
        // TODO: compare file output to its golden.
//        assertEquals("The files differ!",
//                FileUtils.readFileToString(file1, "utf-8"),
//                FileUtils.readFileToString(file2, "utf-8"));
    }

    @Test
    void test2_md_html() throws IOException {
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test2.md";
        Converter.convert(filePath, Format.MARKDOWN, Format.HTML);

        // TODO: compare file output to its golden.
    }

    @Test
    void test2_md_plaintext() throws IOException {
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test2.md";
        Converter.convert(filePath, Format.MARKDOWN, Format.PLAIN_TEXT);

        // TODO: compare file output to its golden.
    }
}
