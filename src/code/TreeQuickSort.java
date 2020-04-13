package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeQuickSort {

    private Integer[] arr;
    private Map<Integer, ArrayList<Integer>> childrenMap = new HashMap<Integer, ArrayList<Integer>>();

    TreeQuickSort(Integer[] arr) {
	this.arr = arr;
    }

    public Integer getLeftChild(int pos) {
	if (pos < arr.length && arr[pos] != null) {
	    int leftChildPos = 2 * pos + 1;
	    if (leftChildPos < arr.length) {
		return leftChildPos;
	    } else {
		return null;
	    }
	}
	return null;
    }

    public Integer getRightChild(int pos) {
	if (pos < arr.length && arr[pos] != null) {
	    int rightChildPos = 2 * pos + 2;
	    if (rightChildPos < arr.length) {
		return rightChildPos;
	    } else {
		return null;
	    }
	}
	return null;
    }

    public List<Integer> getAllChildren(Integer pos) {
	ArrayList<Integer> children = new ArrayList<Integer>();
	if (pos != null) {
	    if (childrenMap.containsKey(pos))
		return childrenMap.get(pos);
	    children.add(pos);
	    Integer left = getLeftChild(pos);
	    Integer right = getRightChild(pos);
	    if (left != null) {
		children.addAll(getAllChildren(left));
	    }
	    if (right != null) {
		children.addAll(getAllChildren(right));
	    }
	    childrenMap.put(pos, children);
	}
	return children;
    }

    private void swap(int x, int y) {
	Integer temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
    }

    public void quickSort(Integer root) {

	if (root != null) {
	    List<Integer> nodes = getAllChildren(root);
	    Collections.sort(nodes, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
		    return arr[o1] - arr[o2];
		}
	    });
	    Integer median = nodes.get(nodes.size() / 2);
	    swap(root, median);
	    List<Integer> leftChildren = getAllChildren(getLeftChild(root));
	    List<Integer> rightChildren = getAllChildren(getRightChild(root));
	    int left = 0;
	    int right = 0;
	    while (left < leftChildren.size() && right < rightChildren.size()) {
		while (left < leftChildren.size()
			&& arr[leftChildren.get(left)] < arr[root]) {
		    left++;
		}
		while (right < rightChildren.size()
			&& arr[rightChildren.get(right)] > arr[root]) {
		    right++;
		}
		if (left < leftChildren.size() && right < rightChildren.size()) {
		    swap(leftChildren.get(left), rightChildren.get(right));
		    left++;
		    right++;
		}
	    }
	    quickSort(getLeftChild(root));
	    quickSort(getRightChild(root));
	}

    }

    public static void main(String[] args) {
	Integer[] arr = { 3, 4, 5, 8, 10, 6 };
	TreeQuickSort tree = new TreeQuickSort(arr);
	tree.quickSort(0);
	System.out.println(Arrays.toString(arr));
    }

}