package code;

//https://app.codility.com/demo/results/trainingMSTU2Q-HZ6/

public class ArrayInversionCount {

    public int solution(int[] A) {
        long inv = countInv(A, 0, A.length - 1);
        return (inv > 1_000_000_000) ? -1 : (int) inv;
    }

    long countInv(int[] A, int st, int end) {
        if (st >= end) return 0;
        int mid = st + (end - st) / 2;
        long count = 0;
        count += countInv(A, st, mid);
        count += countInv(A, mid + 1, end);
        count += merge(A, st, end);
        return count;
    }

    long merge(int[] A, int st, int end) {
        int mid = st + (end - st) / 2;
        int i = st;
        int j = mid + 1;
        int[] C = new int[end - st + 1];
        long count = 0;
        int k = 0;
        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                C[k] = A[i];
                i++;
                k++;
            } else {
                C[k] = A[j];
                j++;
                k++;
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            C[k] = A[i];
            i++;
            k++;
        }
        while (j <= end) {
            C[k] = A[j];
            j++;
            k++;
        }
        for (i = st; i <= end; i++) {
            A[i] = C[i - st];
        }
        return count;
    }
}
