package code;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
	return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int start, int end, int target) {
	if (start <= end) {
	    int mid = (start + end) / 2;
	    if (nums[mid] == target)
		return mid;
	    int left = -1;
	    int right = -1;
	    if (nums[start] < nums[mid]) {
		if (target >= nums[start] && target < nums[mid]) {
		    return binarySearch(nums, start, mid - 1, target);
		}
	    } else {
		left = binarySearch(nums, start, mid - 1, target);
	    }
	    if (mid + 1 <= end && nums[mid + 1] < nums[end]) {
		if (target >= nums[mid + 1] && target <= nums[end]) {
		    return binarySearch(nums, mid + 1, end, target);
		}
	    } else {
		right = binarySearch(nums, mid + 1, end, target);
	    }
	    if (left != -1)
		return left;
	    return right;
	}
	return -1;
    }
}
