package code;

import java.util.ArrayList;
import java.util.List;

public class AddBraces {

    public static List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < len; i++) {
            if (input.charAt(i) == '*' || input.charAt(i) == '+'
                    || input.charAt(i) == '-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1,
                        len));
                for (Integer a : left) {
                    for (Integer b : right) {
                        if (input.charAt(i) == '*') {
                            result.add(a * b);
                        } else if (input.charAt(i) == '+') {
                            result.add(a + b);
                        } else if (input.charAt(i) == '-') {
                            result.add(a - b);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        // Collections.sort(result);
        return result;
    }

    public static void main(String... args) {
        List<Integer> l = diffWaysToCompute("10+5");
        for (Integer i : l) {
            System.out.println(i);
        }
    }

}
