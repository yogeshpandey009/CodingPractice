package code;

/**
 * Find the minimal average of any slice containing at least two elements.
 *
 * @author yogeshpandey
 */
public class MinAvgTwoSlice_ {
    public static void main(String... args) {

    }

    public int solution(int[] A) {
        int[] pSum = prefixSum(A);
        float min_avg = computeAvg(pSum, 0, pSum.length - 1);
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                System.out.print(" i " + i + " j " + j);
                float avg = computeAvg(pSum, i, j + 1);
                System.out.println(" avg " + avg);
                if (avg < min_avg) {
                    min_avg = avg;
                    pos = i;
                }
            }
        }
        return pos;
    }

    private int[] prefixSum(int[] A) {
        int[] pSum = new int[A.length + 1];
        pSum[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            pSum[i] = pSum[i - 1] + A[i - 1];
        }
        return pSum;
    }

    private float computeAvg(int[] pSum, int start, int end) {
        System.out.print(" sum " + (pSum[end] - pSum[start]));
        return (pSum[end] - pSum[start]) / (float) (end - start);
    }
}
