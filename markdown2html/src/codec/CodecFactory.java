package codec;

public class CodecFactory {
    public static Deserializer newDeserializer(Format format) {
        switch (format) {
            case HTML:
                return new HTMLDeserializer();
            case MARKDOWN:
                return new MarkdownDeserializer();
//            case PLAIN_TEXT:
//                break;
            default:
                throw new RuntimeException(
                        String.format("Invalid configuration, deserializer type %s not supported", format));
        }
    }

    public static Serializer newSerializer(Format format) {
        switch (format) {
            case HTML:
                return new HTMLSerializer();
            default:
                throw new RuntimeException(
                        String.format("Invalid configuration, serializer type %s not supported", format));
        }
    }
}
