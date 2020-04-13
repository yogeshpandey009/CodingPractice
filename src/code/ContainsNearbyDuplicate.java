package code;

import java.util.LinkedHashSet;

public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
	LinkedHashSet<Integer> window = new LinkedHashSet<Integer>();
	for (int i = 0; i < nums.length; i++) {
	    if (i > k) {
		if (!window.isEmpty()) {
		    window.remove(window.iterator().next());
		}
	    }
	    Boolean result = window.add(nums[i]);
	    if (result.equals(false)) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String... args) {
	int[] nums = new int[] { -1, -1 };
	int k = 1;
	System.out.println(containsNearbyDuplicate(nums, k));
    }
}
