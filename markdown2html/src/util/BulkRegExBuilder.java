package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BulkRegExBuilder {
    // TODO: use instead a Pair. Maybe from a known library or from my own.
    List<Map.Entry<String, String>> patterns;

    public BulkRegExBuilder() {
        patterns = new LinkedList<>();
    }

    public BulkRegExBuilder add(String regex, String replacement) {
        // TODO: I could just compile the regex here. Consider doing that instead.
        patterns.add(new java.util.AbstractMap.SimpleEntry<>(regex, replacement));
        return this;
    }

    public List<Map.Entry<Pattern, String>>  build() {
        List<Map.Entry<Pattern, String>> compiledRegex = new ArrayList<>(patterns.size());

        for (Map.Entry<String, String> pair : patterns) {
            compiledRegex.add(
                    new java.util.AbstractMap.SimpleEntry<>(
                            Pattern.compile(pair.getKey()),
                            pair.getValue())
            );
        }

        return compiledRegex;
    }
}
