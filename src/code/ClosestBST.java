package code;

public class ClosestBST {

    public static void main(String[] args) {

	int arr[] = { 1, 2, 5, 6, 8 };
	System.out.println(findInSortedArray(arr, 4));
    }

    public int closestBST(TreeNode root, int x) {

	if (root != null) {
	    if (root.val == (int) x)
		return x;
	    if (root.left != null && x < root.val) {
		int left = closestBST(root.left, x);
		if (Math.abs(left - x) < Math.abs(root.val - x))
		    return left;
		return root.val;
	    }
	    if (root.right != null && x > root.val) {
		int right = closestBST(root.right, x);
		if (Math.abs(right - x) < Math.abs(root.val - x))
		    return right;
		return root.val;
	    }
	}
	return -1;
    }

    public static int findInSortedArray(int[] arr, int x) {
	int start = 0;
	int end = arr.length - 1;
	while (start <= end) {
	    if (start == end) {
		return start;
	    }
	    if (start + 1 == end) {
		if (Math.abs(arr[start] - x) < Math.abs(arr[end] - x)) {
		    return start;
		} else {
		    return end;
		}
	    }
	    int mid = (start + end) / 2;
	    if (arr[mid] == x) {
		return mid;
	    } else if (arr[mid] < x) {
		start = mid;
	    } else {
		end = mid;
	    }
	}
	return -1;
    }

}
