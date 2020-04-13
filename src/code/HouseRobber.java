package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<Integer, Integer> dp = new HashMap<Integer, Integer>();

    public int rob(int[] nums) {
	int n = nums.length;
	if (n == 0)
	    return 0;
	return robHelper(nums, 0);
    }

    public int rob2(int[] nums) {
	int n = nums.length;
	if (n == 0)
	    return 0;
	int[] dp = new int[n];
	Arrays.fill(dp, -1);
	return robHelper(nums, dp, 0);
    }

    public int robHelper(int[] nums, int dp[], int from) {
	if (from >= nums.length)
	    return 0;
	if (dp[from] == -1) {
	    int maxFrom = 0;
	    if (from == nums.length - 1) {
		maxFrom = nums[from];
	    } else if (from == nums.length - 2) {
		maxFrom = Math.max(nums[from], nums[from + 1]);
	    } else {
		maxFrom = Math.max(robHelper(nums, dp, from + 1), nums[from]
			+ robHelper(nums, dp, from + 2));
	    }
	    dp[from] = maxFrom;
	}
	return dp[from];
    }

    public int robHelper(int[] nums, int from) {
	if (from >= nums.length)
	    return 0;
	if (!dp.containsKey(from)) {
	    int maxFrom = 0;
	    if (from == nums.length - 1) {
		maxFrom = nums[from];
	    } else if (from == nums.length - 2) {
		maxFrom = Math.max(nums[from], nums[from + 1]);
	    } else {
		maxFrom = Math.max(robHelper(nums, from + 1), nums[from]
			+ robHelper(nums, from + 2));
	    }
	    dp.put(from, maxFrom);
	}
	return dp.get(from);
    }

}
