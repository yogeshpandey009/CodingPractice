package code;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubArray {
    public static void main(String... args) {
        // int a = MaxSubArraySum(new int [] {5, -7, 3, 5, -2, 4, -1});
        // int b = MaxSubArraySum(new int [] {-5, -7, -3, -5, -2, -4, -1});
        int s = MaxProfit(new int[]{23171, 21011, 21123, 21366, 21013, 21367});
        // System.out.println(a);
        System.out.println(s);
    }

    public static int MaxSubArraySum(int[] arr) {
        if (arr.length == 0)
            return 0;
        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static int MaxProfit(int[] arr) {
        int prev = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int next = arr[i];
            arr[i] = arr[i] - prev;
            prev = next;
        }
        // arr[0] = 0;
        System.out.println(Arrays.toString(arr));
        ;
        return MaxSubArraySum(arr);
    }

    public static void hackerrank(String[] args) {
        /*
         * Given an array A={a1,a2,…,aN} of N elements, find the maximum
         * possible sum of a
         *
         * Contiguous subarray Non-contiguous (not necessarily contiguous)
         * subarray. Empty subarrays/subsequences should not be considered.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int curr_csum = 0;
            int max_csum = 0;
            int max_ncsum = 0;
            boolean allNegative = true;
            for (int j = 0; j < t; j++) {
                int x = sc.nextInt();
                if (j == 0) {
                    if (x > 0) {
                        curr_csum = x;
                        allNegative = false;
                    }
                    max_ncsum = x;
                    max_csum = x;

                } else {
                    curr_csum = curr_csum + x;
                    if (x > 0) {
                        allNegative = false;
                        if (max_ncsum < 0) {
                            max_ncsum = x;
                        } else {
                            max_ncsum = max_ncsum + x;
                        }
                    } else {
                        if (curr_csum < 0) {
                            curr_csum = 0;
                        }
                        if (x > max_ncsum) {
                            max_ncsum = x;
                        }
                        if (x > max_csum) {
                            max_csum = x;
                        }
                    }
                    if (!allNegative && curr_csum > max_csum) {
                        max_csum = curr_csum;
                    }
                }
            }
            System.out.println(max_csum + " " + max_ncsum);
        }
    }
}
