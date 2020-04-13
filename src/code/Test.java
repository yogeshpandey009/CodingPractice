package code;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "    123456";
        int count = s.indexOf(s.trim());
        System.out.println(count);
        int n = 5;
        int[] c = {0, 3};
        int prev = c[0];
        String a = "1 ";
        String[] ar = a.split(" ");
        System.out.println(Arrays.toString(ar));
        System.out.println(reverseWords("1 "));
    }

    public static String reverseWords(String s) {
        s = reverse(s);
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words.length >= 1) {
            sb.append(reverse(words[0]));
            for (int i = 1; i < words.length; i++) {
                sb.append(" ").append(reverse(words[i]));
            }
        }
        return sb.toString();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
