package code;

import java.util.ArrayList;
import java.util.List;

public class RotationSym {

    public static void main(String[] args) {
        solution(5);
    }

    private static List<List<String>> solution(int n) {
        List<List<String>> dp = new ArrayList<List<String>>();
        String[] l = new String[]{"0", "1", "8", "6", "9"};
        dp.add(new ArrayList<String>() {
            {
                add("0");
                add("1");
                add("8");
            }
        });
        dp.add(new ArrayList<String>() {
            {
                add("00");
                add("11");
                add("88");
                add("69");
                add("96");
            }
        });
        for (int i = 2; i < n; i++) {
            List<String> list = new ArrayList<String>();
            for (String prev : dp.get(i - 2)) {
                for (String s : l) {
                    if (s.equals("6")) {
                        list.add(s + prev + "9");
                    } else if (s.equals("9")) {
                        list.add(s + prev + "6");
                    } else {
                        list.add(s + prev + s);
                    }
                }
            }
            System.out.println(list.toString());
            dp.add(list);
        }
        return dp;
    }

}
