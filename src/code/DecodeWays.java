package code;

public class DecodeWays {
    public int numDecodings(String s) {
	if (s.length() == 0)
	    return 0;
	int[] dp = new int[s.length() + 1];
	int prev = Integer.parseInt(s.charAt(s.length() - 1) + "");
	dp[s.length() - 1] = 1;
	dp[s.length()] = 1;
	if (prev == 0) {
	    dp[s.length() - 1] = 0;
	}
	for (int i = s.length() - 2; i >= 0; i--) {
	    int curr = Integer.parseInt(s.charAt(i) + "");
	    if (curr != 0) {
		if (curr * 10 + prev <= 26) {
		    dp[i] = dp[i + 1] + dp[i + 2];
		} else {
		    dp[i] = dp[i + 1];
		}
	    }
	    prev = curr;
	}
	return dp[0];
    }
}