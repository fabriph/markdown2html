package codec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkdownDeserializerTest {
    @Test
    void deserializeUnformattedText() {
        MarkdownDeserializer deserializer = new MarkdownDeserializer();

        String result = deserializer.deserialize("Unformatted text");

        Assertions.assertEquals("<p>Unformatted text</p>", result);
    }

    @Test
    void deserializeH1() {
        MarkdownDeserializer deserializer = new MarkdownDeserializer();

        String result = deserializer.deserialize("# title");

        Assertions.assertEquals("<h1>title</h1>", result);
    }

    @Test
    void deserializeH2() {
        MarkdownDeserializer deserializer = new MarkdownDeserializer();

        String result = deserializer.deserialize("## subtitle");

        Assertions.assertEquals("<h2>subtitle</h2>", result);
    }

    @Test
    void deserializeH6() {
        MarkdownDeserializer deserializer = new MarkdownDeserializer();

        String result = deserializer.deserialize("###### title 6");

        Assertions.assertEquals("<h6>title 6</h6>", result);
    }

    @Test
    void deserializeLink() {
        MarkdownDeserializer deserializer = new MarkdownDeserializer();

        String result = deserializer.deserialize("[Link text](https://www.example.com)");

        Assertions.assertEquals("<p><a href=\"https://www.example.com\">Link text</a></p>", result);
    }
}