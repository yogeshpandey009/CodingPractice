package code;

public class EquiIndex {

    public int solution(int[] A) {
        int N = A.length;
        if (N == 0 || N == 1)
            return N - 1;
        long sum = 0;
        for (int x : A) {
            sum += x;
        }
        long leftSum = 0;
        for (int i = 0; i < N; i++) {
            if (leftSum == (sum - leftSum - (long) A[i]))
                return i;
            leftSum += (long) A[i];
        }
        return -1;
    }
}
