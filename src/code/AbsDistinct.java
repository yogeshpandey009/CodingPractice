package code;
//https://app.codility.com/demo/results/trainingA266JZ-NEZ/
//https://codility.com/demo/results/training5CJT98-BM6/

public class AbsDistinct {

    public int solution(int[] arr) {
        // initialize count as number of elements
        int n = arr.length;
        int count = n;
        int i = 0, j = n - 1, sum = 0;

        while (i < j)
        {
            // Remove duplicate elements from the
            // left of the current window (i, j)
            // and also decrease the count
            while (i != j && arr[i] == arr[i + 1]) {
                count--; i++;
            }

            // Remove duplicate elements from the
            // right of the current window (i, j)
            // and also decrease the count
            while (i != j && arr[j] == arr[j - 1]) {
                count--; j--;
            }
            // break if only one element is left
            if (i == j)
                break;

            // Now look for the zero sum pair
            // in current window (i, j)
            sum = arr[i] + arr[j];

            if (sum == 0)
            {
                // decrease the count if (positive,
                // negative) pair is encountered
                count--;
                i++; j--;
            }
            else if(sum < 0)
                i++;
            else
                j--;
        }

        return count;
    }

    public int old_solution(int[] A) {
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
