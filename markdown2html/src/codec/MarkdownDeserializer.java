package codec;

import util.BulkRegExBuilder;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MarkdownDeserializer implements Deserializer {
    List<Map.Entry<Pattern, String>> patterns;

    MarkdownDeserializer() {
        BulkRegExBuilder builder = new BulkRegExBuilder();
        patterns = builder
                .add("^# (.*)", "<h1>$1</h1>")  // H1
                .add("^## (.*)", "<h2>$1</h2>")  // H2
                .build();
    }

    @Override
    public String deserialize(String input) {
        String transform = input;
        for (Map.Entry<Pattern, String> pair : patterns) {
            transform = pair.getKey().matcher(transform).replaceAll(pair.getValue());
        }

        /*
        v2
        Pattern p = Pattern.compile("^# (.*)");
        return p.matcher(input).replaceAll("<h1>$1</h1>");
         */

        // V1
//        return input
//                .replaceAll("^# (.*)", "<h1>$1</h1>")
//                .replaceAll("^## (.*)", "<h2>$1</h2>");
        return transform;
    }
}
