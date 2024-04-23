package codec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkdownDeserializerTest {
    @Test
    void deserializeNoop() {
        MarkdownDeserializer deserializer = new MarkdownDeserializer();

        String result = deserializer.deserialize("noop text");

        Assertions.assertEquals("noop text", result);
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
}