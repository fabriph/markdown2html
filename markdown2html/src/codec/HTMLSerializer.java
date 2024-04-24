package codec;

public class HTMLSerializer implements Serializer {
    /**
     * Whether the last emitted line was a paragraph tag or not.
     */
    private boolean previousLineIsParagraph = false;

    @Override
    public String serialize(String input) {
        // Noop.
        return input;
    }

    /**
     * HTML files should reconcile the potential multiple <p> ... </p>.
     *
     * ABC  <-- previousLineWasParagraph
     * DEF  <-- convertedLine
     * GHI  <-- nextConvertedLine
     * ...
     */
    @Override
    public String reconcileMultilineArtifacts(String convertedLine, String nextConvertedLine) {
        boolean currentLineIsParagraph = convertedLine.startsWith("<p>");

        // Assess whether `convertedLine` should have an opening <p>.
        if (currentLineIsParagraph && previousLineIsParagraph) {
            // No need to emit <p> in `convertedLine` because the line above it already had it.
            convertedLine = convertedLine.substring(3);  // 3 is the size of `<p>`
        }

        // Assess whether `convertedLine` should have a closing </p>.
        if (currentLineIsParagraph && nextConvertedLine != null && nextConvertedLine.startsWith("<p>")) {
            // No need to emit </p> in `convertedLine` because the line below will be a paragraph too.
            convertedLine = convertedLine.substring(0, convertedLine.length() - 4);  // 4 is the size of `</p>`
        }

        // Advance.
        previousLineIsParagraph = currentLineIsParagraph;
        return convertedLine;
    }
}
