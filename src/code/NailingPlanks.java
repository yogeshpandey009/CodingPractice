package code;

//https://app.codility.com/demo/results/trainingYUH3E2-UAZ/
//Better: https://app.codility.com/demo/results/training4KQWRH-FCK/

import java.util.Arrays;

public class NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {

        int[][] planks = new int[A.length][2];

        for (int i = 0; i < A.length; i++) {
            planks[i] = new int[]{A[i], B[i]};
        }
        int st = 0;
        int end = C.length - 1;
        int res = -2;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            boolean flag = canPlank(planks, C, mid);
            if (flag) {
                res = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return res + 1;
    }

    boolean canPlank(int[][] planks, int[] C, int M) {
        int[] sortedC = Arrays.copyOfRange(C, 0, M + 1);
        Arrays.sort(sortedC);
        boolean flag = true;
        for (int i = 0; i < planks.length; i++) {
            int pos = search(sortedC, planks[i][0]);
            if (pos == -1 || sortedC[pos] > planks[i][1])
                return false;
            /*
            https://app.codility.com/demo/results/training8HJV24-WBA/
            int pos = Arrays.binarySearch(sortedC, planks[i][0]);
            if (pos < 0) {
                pos = (pos * -1) - 1;
                if (pos > M || planks[i][1] < sortedC[pos]) {
                    return false;
                }
            }
            */
        }

        return flag;
    }


    int search(int[] arr, int val) {
        int st = 0;
        int end = arr.length - 1;
        int pos = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] >= val) {
                pos = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return pos;
    }
    /*
    boolean canPlank(int[][] planks, int[] C, int M) {
        int n = planks.length;
        boolean[] done = new boolean[n];
        for (int i = 0; i <= M && n > 0; i++) {
            for (int j = 0; j < planks.length && n > 0; j++) {
                if (C[i] >= planks[j][0] && C[i] <= planks[j][1] && !done[j]) {
                    n--;
                    done[j] = true;
                }
                if (planks[j][0] > C[i]) break;
            }
        }
        return n == 0;
    }
     */
}