package codec;

import util.BulkRegExBuilder;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PlainTextSerializer implements Serializer {
    List<Map.Entry<Pattern, String>> patterns;

    PlainTextSerializer() {
        BulkRegExBuilder builder = new BulkRegExBuilder();
        patterns = builder
                // TODO: this could be implemented as a single regex.
                .add("^<h1>(.*)</h1>", "$1")  // H1
                .add("^<h2>(.*)</h2>", "$1")  // H2
                .add("^<h3>(.*)</h3>", "$1")  // H3
                .add("^<h4>(.*)</h4>", "$1")  // H4
                .add("^<h5>(.*)</h5>", "$1")  // H5
                .add("^<h6>(.*)</h6>", "$1")  // H6
                .add("<a href=\\\".*\\\">(.*)</a>", "$1")// Link, discards hyperlink.
                .build();
    }

    @Override
    public String serialize(String input) {
        String transform = input;
        for (Map.Entry<Pattern, String> pair : patterns) {
            transform = pair.getKey().matcher(transform).replaceAll(pair.getValue());
        }
        return transform;
    }
}
