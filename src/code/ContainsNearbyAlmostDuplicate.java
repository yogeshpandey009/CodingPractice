package code;

import java.util.LinkedHashSet;

public class ContainsNearbyAlmostDuplicate {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	LinkedHashSet<Integer> window = new LinkedHashSet<Integer>();
	for (int i = 0; i < nums.length; i++) {
	    if (i > k) {
		if (!window.isEmpty()) {
		    window.remove(nums[i - k - 1]);
		}
	    }
	    if (k < t) {
		for (int x : window) {
		    if (Math.abs((long) x - (long) nums[i]) <= t)
			return true;
		}
	    } else {
		int prev = nums[i];
		int next = nums[i];
		int j = 0;
		while (j <= t) {
		    if (window.contains(prev) || window.contains(next)) {
			break;
		    }
		    prev--;
		    next++;
		    j++;
		}
		if (j <= t) {
		    return true;
		}
	    }
	    window.add(nums[i]);
	}
	return false;
    }

    public static void main(String... args) {
	int[] arr = new int[] { -1, 2147483647 };
	System.out.println(containsNearbyAlmostDuplicate(arr, 1, 2147483647));
    }
}
