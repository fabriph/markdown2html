package codec;

public class CodecFactory {
    public static Deserializer newDeserializer(Format format) {
        switch (format) {
            case HTML:
                return new HTMLDeserializer();
            case MARKDOWN:
                return new MarkdownDeserializer();
            default:
                throw new RuntimeException(
                        String.format("Invalid configuration, deserializer type %s not supported", format));
        }
    }

    public static Serializer newSerializer(Format format) {
        switch (format) {
            case HTML:
                return new HTMLSerializer();
            case PLAIN_TEXT:
                return new PlainTextSerializer();
            default:
                throw new RuntimeException(
                        String.format("Invalid configuration, serializer type %s not supported", format));
        }
    }
}
