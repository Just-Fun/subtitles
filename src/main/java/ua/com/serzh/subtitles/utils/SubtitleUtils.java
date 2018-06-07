package ua.com.serzh.subtitles.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SubtitleUtils {

    private final static String prefix = "<i>";

    private final static String suffix = "</i>";

    public static List<String> getSubtitles(List<String> lines) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean startSentenceWithPrefix = false;
        for (String line : lines) {
            if (startSentenceWithPrefix) {
                startSentenceWithPrefix = !line.endsWith(suffix);
                String replace = line.replace(suffix, "");
                addSpace(builder);
                builder.append(replace);
                ifEndOfSentence(result, builder, line);
            } else if (line.startsWith(prefix)) {
                startSentenceWithPrefix = !line.endsWith(suffix);
                String replace = line.replace(prefix, "").replace(suffix, "");
                addSpace(builder);
                builder.append(replace);
                ifEndOfSentence(result, builder, line);
            } else if (line.startsWith("-") || startsWithLetter(line) || line.startsWith("\"")) {
                addSpace(builder);
                builder.append(line);
                ifEndOfSentence(result, builder, line);
            }
        }
        return result;
    }

    private static void ifEndOfSentence(List<String> result, StringBuilder builder1, String line) {
        if (line.endsWith(".") || line.endsWith("!") || line.endsWith("?") || line.endsWith("\"")) {
            result.add(builder1.toString());
            builder1.setLength(0);
        }
    }

    private static void addSpace(StringBuilder builder1) {
        if (builder1.length() != 0) {
            builder1.append(" ");
        }
    }

    private static boolean startsWithLetter(String s) {
        return Pattern.compile("^[a-zA-Z]").matcher(s).find();
    }


}
