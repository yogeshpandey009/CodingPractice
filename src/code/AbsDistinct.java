package code;

//https://codility.com/demo/results/training5CJT98-BM6/
public class AbsDistinct {

    public int solution(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int count = 0;
        long prev = Long.MAX_VALUE;
        while (start <= end) {
            long sVal = Math.abs((long) A[start]);
            long eVal = Math.abs((long) A[end]);
            if (sVal == eVal) {
                if (sVal != prev) {
                    count++;
                }
                start++;
                end--;
                prev = sVal;
            } else if (sVal < eVal) {
                if (eVal != prev) {
                    count++;
                }
                end--;
                prev = eVal;
            } else {
                if (sVal != prev) {
                    count++;
                }
                start++;
                prev = sVal;
            }
        }
        return count;
    }
}
