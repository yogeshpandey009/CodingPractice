package code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class TreeTraversal {

    static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public static void main(String[] args) {

	TreeNode t = new TreeNode(1);
	t.left = new TreeNode(2);
	t.right = new TreeNode(3);
	rightSideView(t);
    }

    public static List<Integer> rightSideView(TreeNode root) {
	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
	Queue<TreeNode> q2 = new ArrayDeque<TreeNode>();
	List<Integer> result = new ArrayList<Integer>();
	q1.add(root);
	while (!q1.isEmpty() || !q2.isEmpty()) {
	    TreeNode n = null;
	    while (!q1.isEmpty()) {
		n = q1.poll();
		if (n.right != null)
		    q2.add(n.left);
		if (n.left != null)
		    q2.add(n.right);
		System.out.println(n.val);
		if (q1.isEmpty())
		    result.add(n.val);
	    }
	    while (!q2.isEmpty()) {
		n = q2.poll();
		if (n.left != null)
		    q1.add(n.left);
		if (n.right != null)
		    q1.add(n.right);
		System.out.println(n.val);
		if (q2.isEmpty())
		    result.add(n.val);
	    }
	}
	return result;
    }

}