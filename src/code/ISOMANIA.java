package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ISOMANIA {

    public static void main(String... args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("insomnia/in3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File file = new File("insomnia/out3.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();
            int i = 1;
            sc.nextInt();
            while (sc.hasNext()) {
                int x = sc.nextInt();
                int result = solution(x);
                sb.append("Case #").append(i + "").append(": ")
                        .append(result == -1 ? "INSOMNIA\n" : result + "\n");
                i++;
            }

            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static int solution(int x) {
        int curr = x;
        Set<Integer> set = new HashSet<Integer>();
        Set<Character> digits = new HashSet<Character>();
        while (true) {
            String s = curr + "";
            char[] c_arr = s.toCharArray();
            for (char c : c_arr) {
                digits.add(c);
            }
            ;
            if (digits.size() == 10)
                return curr;
            if (set.add(curr) == false) {
                return -1;
            }
            curr = curr + x;
        }
    }
}
