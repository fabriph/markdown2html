
import codec.Format;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GoldenTestRunner {
    @Test
    void test1() throws IOException {
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test1.md";
        Converter.convert(filePath, Format.MARKDOWN, Format.HTML);

        // TODO: compare file output to its golden.
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

    @Test
    void test_empty_md_html() throws IOException {
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test-empty.md";
        Converter.convert(filePath, Format.MARKDOWN, Format.HTML);

        // TODO: compare file output to its golden.
    }

    @Test
    void test_blank_lines_md_html() throws IOException {
        String filePath = "/Users/fabriph/dev/markdown2html/markdown2html/test/input/test-blank-lines.md";
        Converter.convert(filePath, Format.MARKDOWN, Format.HTML);

        // TODO: compare file output to its golden.
    }
}
