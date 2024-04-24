package codec;

public interface Serializer {
    /**
     * Converts {@code input} from this framework internal representation format to a known format.
     * @param input The String to be converted.
     * @return The converted String.
     */
    String serialize(String input);
}
