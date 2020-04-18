package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class GoogleCodeJam {
    Scanner sc = new Scanner(getClass().getResourceAsStream(IN));
    //Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";

    private void solve() {
        int ans = 0;

        System.out.println(ans);
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        System.out.close();
    }

    public static void main(String args[]) throws Exception {
        new GoogleCodeJam().run();
    }

}