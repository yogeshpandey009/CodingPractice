package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TidyNumber {

    public static void main(String[] args) throws IOException {
        /*
         * System.out.println(findTidyNumber("113322"));
         * System.out.println(findTidyNumber("129"));
         * System.out.println(findTidyNumber("100"));
         * System.out.println(findTidyNumber("8"));
         * System.out.println(findTidyNumber("12"));
         * System.out.println(findTidyNumber("21"));
         * System.out.println(findTidyNumber("999"));
         * System.out.println(findTidyNumber("4411"));
         * System.out.println(findTidyNumber("1111110"));
         * System.out.println(findTidyNumber("1001110"));
         * System.out.println(findTidyNumber("111000"));
         * System.out.println(findTidyNumber("132"));
         * System.out.println(findTidyNumber("627"));
         * System.out.println(findTidyNumber("987654"));
         * System.out.println(findTidyNumber("3444321"));
         */
        File in = new File("google/input.txt");
        File out = new File("google/output.txt");

        Scanner sc = new Scanner(in);
        FileWriter fw = new FileWriter(out);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String s = sc.next();
            fw.write("Case #" + i + ": " + findTidyNumber(s) + "\n");
        }
        sc.close();
        fw.close();
    }

    private static String findTidyNumber(String str) {
        int l = str.length();
        StringBuilder tidyNum = new StringBuilder();
        char[] digits = str.toCharArray();
        char prev = digits[0];
        int c = 0;
        int i = 1;
        for (; i < l; i++) {
            char curr = digits[i];
            if (prev == curr) {
                c++;
                prev = curr;
            } else if (prev < curr) {
                for (; c > 0; c--) {
                    tidyNum.append(prev);
                }
                tidyNum.append(prev);
                prev = curr;
            } else {
                if (prev != '1') {
                    tidyNum.append((char) (prev - 1));
                }
                for (i = i - c; i < l; i++) {
                    tidyNum.append('9');
                }
            }
        }
        if (i == l) {
            for (; c >= 0; c--) {
                tidyNum.append(prev);
            }
        }
        return tidyNum.toString();
    }
}
