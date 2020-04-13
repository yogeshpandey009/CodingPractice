package code;

import java.util.*;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
	val = x;
    }
}

public class BFS_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	if (root != null)
	    queue.add(root);
	int sizeParent = 1;
	int size;
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	while (!queue.isEmpty()) {
	    List<Integer> list = new ArrayList<Integer>();
	    size = 0;
	    for (int i = 0; i < sizeParent; i++) {
		TreeNode node = queue.poll();
		list.add(node.val);
		if (node.left != null) {
		    queue.add(node.left);
		    size++;
		}
		if (node.right != null) {
		    queue.add(node.right);
		    size++;
		}
	    }
	    sizeParent = size;
	    result.add(list);
	}
	return result;
    }
}
