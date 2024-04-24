package codec;

public interface Deserializer {
    /**
     * Converts {@code input} from a known format to this framework internal representation format.
     * @param input The string to be converted. Nullable.
     * @return The converted String.
     */
    String deserialize(String input);
}
