package code;

import java.util.Arrays;

//https://codility.com/demo/results/trainingHB4HN5-KCN/
public class Flags {
    public static void main(String[] args) {
        // int f = countFlags(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 });
        // int f = countFlags(new int[] { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 });
        int f = countFlags(new int[]{1, 3, 2});
        System.out.println(f);
    }

    public static int countFlags(int[] A) {
        int[] peeks_dis = new int[A.length];
        int peeks_c = 0;
        int firstPeek = 0;
        int lastPeek = 0;
        int prev = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                if (prev == 0) {
                    firstPeek = i;
                } else {
                    peeks_dis[peeks_c] = i - prev;
                }
                peeks_c++;
                lastPeek = i;
                prev = i;
            }
        }
        System.out.println(Arrays.toString(peeks_dis));
        int n = Math.min((int) Math.sqrt(lastPeek - firstPeek) + 1, peeks_c);
        System.out.println(n);
        while (n != 0) {
            int flags = 1;
            for (int i = 1; i < peeks_c; i++) {
                int sum = 0;
                int j = i;
                for (; j < peeks_c; j++) {
                    sum += peeks_dis[j];
                    if (sum >= n) {
                        System.out.println(n + " place at " + i + " " + j);
                        flags++;
                        if (flags >= n)
                            return n;
                        break;
                    }
                }
                i = j;
            }
            if (flags >= n)
                return n;
            n--;
        }
        return n;
    }
}
