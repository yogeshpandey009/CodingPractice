package code;

public class Palindrome_ {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(count_palindrome("aaaa"));
        System.out.println(count_palindrome("hellolle"));
        System.out.println(count_palindrome("wowpurerocks"));
    }

    public static String longestPalindrome_(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int maxLen = -1;
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] == true) {
                    if (j - i > maxLen) {
                        maxLen = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static String longestPalindrome(String s) {
        String lonPal = "";
        for (int i = 0; i < s.length(); i++) {
            String pal1 = expandFromCenter(s, i, i);
            String pal2 = expandFromCenter(s, i, i + 1);
            int lonPalLen = lonPal.length();
            if (lonPalLen < pal1.length()) {
                lonPal = pal1;
            }
            if (lonPalLen < pal2.length()) {
                lonPal = pal2;
            }
        }
        return lonPal;
    }

    private static String expandFromCenter(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static int count_palindrome(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = expandFromCenterCount(s, i, i);
            int m = expandFromCenterCount(s, i, i + 1);
            total += n + m;
        }
        return total;
    }

    private static int expandFromCenterCount(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return (r - l) / 2;
    }
}
