package code;

import java.util.Arrays;

public class DPCoinChange {

    public static void main(String[] args) {
        // int[] dp = dp_coin_change(new int[] { 1, 3, 4 }, 6);
        coin_change_ways();
        // System.out.println(Arrays.toString(dp));
    }

    public static int[] dp_coin_change(int[] coins, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                if (dp[j - coins[i]] + 1 < dp[j] || i == 0) {
                    dp[j] = dp[j - coins[i]] + 1;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp;
    }

    public static void coin_change_ways() {
        int[] coins = new int[]{3, 2, 1};
        int n = 4;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += (long) dp[j - coins[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
