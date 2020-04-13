package code;

import java.util.ArrayList;
import java.util.List;

public class JustifyGreedyText {
    public static void main(String[] args) {
        JustifyGreedyText m = new JustifyGreedyText();
        // String[] words = new String[]{ "This", "is", "an", "example", "of",
        // "text", "justification."};
        // String[] words = new String[]{
        // "Listen","to","many,","speak","to","a","few." };
        // int maxWidth = 16;
        // int maxWidth = 6;
        String[] words = new String[]{"What", "must", "be", "shall", "be."};
        int maxWidth = 12;

        System.out.println(m.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        if (maxWidth <= 0) {
            result.add(new String());
            return result;
        }
        boolean isFirst = true;
        int remSpace = maxWidth;
        for (int i = 0; i < words.length; i++) {
            if (isFirst && remSpace - words[i].length() >= 0) {
                remSpace = remSpace - words[i].length();
                isFirst = false;
                line.add(words[i]);
            } else if (remSpace - words[i].length() - 1 >= 0) {
                remSpace = remSpace - words[i].length() - 1;
                line.add(words[i]);
            } else {
                result.add(justify(line, remSpace));
                line = new ArrayList<String>();
                remSpace = maxWidth;
                isFirst = true;
                i--;
            }
            System.out.println("remSpace " + remSpace);
        }
        result.add(justifyLast(line, remSpace));
        return result;
    }

    String justify(List<String> line, int remSpace) {
        int count = line.size() - 1;
        int spaces = 0;
        int extraSpaces = 0;
        if (count != 0) {
            spaces = remSpace / count;
            extraSpaces = remSpace % count;
        } else {
            extraSpaces = remSpace;
        }

        StringBuilder out = new StringBuilder();
        out.append(line.get(0));
        for (int i = 1; i < line.size(); i++) {
            out.append(" ");
            for (int j = 0; j < spaces; j++) {
                out.append(" ");
            }
            if (extraSpaces != 0) {
                out.append(" ");
                extraSpaces--;
            }
            out.append(line.get(i));
        }
        if (extraSpaces != 0) {
            out.append(" ");
            extraSpaces--;
        }
        return out.toString();
    }

    String justifyLast(List<String> line, int remSpace) {
        StringBuilder out = new StringBuilder();
        out.append(String.join(" ", line));
        int spaces = remSpace;
        for (int j = 0; j < spaces; j++) {
            out.append(" ");
        }
        return out.toString();
    }
}