package codec;

import util.BulkRegExBuilder;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Converts Markdown content to HTML.
 */
public class MarkdownDeserializer implements Deserializer {
    List<Map.Entry<Pattern, String>> patterns;

    MarkdownDeserializer() {
        BulkRegExBuilder builder = new BulkRegExBuilder();
        patterns = builder
                // Unformatted text. Needs to go first because order matters when transforming the text.
                // TODO: consider finding a less hacky way to implement unformatted text.
                .add("^([^#].*)", "<p>$1</p>")

                // TODO: headings could be implemented as a single regex.
                .add("^# (.*)", "<h1>$1</h1>")  // H1
                .add("^## (.*)", "<h2>$1</h2>")  // H2
                .add("^### (.*)", "<h3>$1</h3>")  // H3
                .add("^#### (.*)", "<h4>$1</h4>")  // H4
                .add("^##### (.*)", "<h5>$1</h5>")  // H5
                .add("^###### (.*)", "<h6>$1</h6>")  // H6

                // Example: "[Link text](https://www.example.com)"
                // to "<a href=\"https://www.example.com\">Link text</a>"
                .add("\\[(.*)\\]\\((.*)\\)", "<a href=\\\"$2\\\">$1</a>")  // Link
                .build();
    }

    @Override
    public String deserialize(String input) {
        if (input == null) {
            return null;
        }

        String transform = input;
        for (Map.Entry<Pattern, String> pair : patterns) {
            transform = pair.getKey().matcher(transform).replaceAll(pair.getValue());
        }
        return transform;
    }
}
