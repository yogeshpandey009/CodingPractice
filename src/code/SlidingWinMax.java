package code;

import java.util.LinkedList;

public class SlidingWinMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = {};
        if (k == 0 || n - k < 0)
            return result;
        result = new int[n - k + 1];
        LinkedList<Integer> doublyQueue = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!doublyQueue.isEmpty()
                    && nums[doublyQueue.getLast()] <= nums[i]) {
                doublyQueue.removeLast();
            }
            doublyQueue.add(i);
        }
        result[0] = nums[doublyQueue.getFirst()];
        for (int i = k; i < n; i++) {
            while (!doublyQueue.isEmpty()
                    && nums[doublyQueue.getLast()] <= nums[i]) {
                doublyQueue.removeLast();
            }
            doublyQueue.add(i);
            if (!doublyQueue.isEmpty() && doublyQueue.getFirst() <= i - k) {
                doublyQueue.remove();
            }
            result[i - k + 1] = nums[doublyQueue.getFirst()];
        }
        return result;
    }
}