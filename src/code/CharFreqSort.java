package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CharNode implements Comparable<CharNode> {
    char c;
    int count;

    CharNode(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public int compareTo(CharNode obj) {
        return this.count - obj.count;
    }
}

public class CharFreqSort {

    public String frequencySort(String s) {
        int[] freq = new int[52];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int i = c - 65;
            if (i > 26) {
                i = i - 6;
            }
            freq[i] += 1;
        }
        List<CharNode> list = new ArrayList<CharNode>();
        for (int i = 0; i < 52; i++) {
            char c = '-';
            if (freq[i] > 0) {
                if (i <= 26) {
                    c = (char) (i + 65);
                } else {
                    c = (char) (i - 26 + 97);
                }
                list.add(new CharNode(c, freq[i]));
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (CharNode node : list) {
            char c = node.c;
            int count = node.count;
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}