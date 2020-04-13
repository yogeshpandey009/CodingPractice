package code;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
	Arrays.sort(nums);
	int minDiff = Integer.MAX_VALUE;
	int minSum = Integer.MAX_VALUE;
	for (int i = 0; i < nums.length - 2; i++) {
	    int start = i + 1;
	    int end = nums.length - 1;
	    while (start < end) {
		int sum = nums[i] + nums[start] + nums[end];
		int diff = Math.abs(target - sum);
		if (diff < minDiff) {
		    minDiff = diff;
		    minSum = sum;
		}
		// System.out.println(" start " + start + " end " + end + " i "
		// + i + " sum " + sum + " diff " + diff + " minDiff " + minDiff
		// );
		if (sum > target) {
		    end--;
		} else if (sum < target) {
		    start++;
		} else {
		    return sum;
		}
	    }
	}
	return minSum;
    }
}