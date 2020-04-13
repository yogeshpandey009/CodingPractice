package code;

import java.util.HashMap;
import java.util.Map;

public class BalanceArrays {

    public static boolean solution(int[] A, int[] B) {

        long sumA = 0;
        long sumB = 0;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            freqMap.put(B[i], 1);
            sumB += B[i];
        }
        int d = (int) (sumA - sumB);
        if (d % 2 != 0)
            return false;
        d /= 2;
        for (int i = 0; i < A.length; i++) {
            int diff = A[i] - d;
            if (freqMap.get(diff) != null && freqMap.get(diff).equals(1)) {
                System.out.println(diff + " " + A[i]);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{2, 3, 5};
        System.out.println(solution(a, b));
    }
}
