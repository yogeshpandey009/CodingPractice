package code;

import java.util.Arrays;

//https://app.codility.com/demo/results/trainingU3YNFB-8S3/
public class MinAbsSumTwo {
    public int solution(int[] A) {
        Arrays.sort(A);
        int st = 0;
        int end = A.length -1;
        int minAbsSum = Integer.MAX_VALUE;
        while(st <= end) {
            int sum = A[st] + A[end];
            minAbsSum = Math.min(minAbsSum, Math.abs(sum));
            if (Math.abs(A[st]) > Math.abs(A[end])) {
                st++;
            } else if (Math.abs(A[st]) < Math.abs(A[end])) {
                end--;
            } else { // both same or op sign
                break;
            }
        }
        return minAbsSum;
    }
}