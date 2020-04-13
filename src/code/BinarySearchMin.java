package code;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class BinarySearchMin {

    public int findMin(int[] nums) {
        return binarySearchMin(nums, 0, nums.length - 1);
    }

    private int binarySearchMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else if (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                int min1 = nums[mid];
                int min2 = binarySearchMin(nums, start, mid - 1);
                return Math.min(min1, min2);
            } else if (nums[mid] >= nums[start]) {
                int min1 = nums[start];
                int min2 = binarySearchMin(nums, mid + 1, end);
                return Math.min(min1, min2);
            }
        }
        return Integer.MAX_VALUE;
    }
}