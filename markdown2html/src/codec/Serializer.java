package codec;

public interface Serializer {
    /**
     * Converts {@code input} from this framework internal representation format to a known format.
     * @param input The String to be converted. Nullable.
     * @return The converted String.
     */
    String serialize(String input);

    /**
     * Reconciles {@code convertedLine} so it complies with the representation format.
     * @return The reconciled {@code convertedLine}.
     */
    String reconcileMultilineArtifacts(String convertedLine, String nextConvertedLine);
}
