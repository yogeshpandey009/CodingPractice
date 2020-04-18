package code;

import java.util.ArrayList;

//Old approach: https://codility.com/demo/results/trainingHB4HN5-KCN/
// Better: https://app.codility.com/demo/results/trainingAVQBHF-QRE/

public class Flags {
    public static void main(String[] args) {
        // int f = countFlags(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 });
        // int f = countFlags(new int[] { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 });
        int f = countFlags(new int[]{1, 3, 2});
        System.out.println(f);
    }


    public static int countFlags(int[] A) {

        ArrayList<Integer> peeks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peeks.add(i);
            }
        }
        if (peeks.size() == 0) return 0;

        int high = peeks.size();
        int low = 1;
        int result = low;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            boolean success = false;
            int prev = peeks.get(0);
            int count = 1;
            for (int i = 1; i < peeks.size(); i++) {
                int curr = peeks.get(i);
                if (curr - prev >= mid) {
                    prev = curr;
                    count++;
                    if (count >= mid) {
                        success = true;
                        break;
                    }
                }
            }

            if (success) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}

/*
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
 */
