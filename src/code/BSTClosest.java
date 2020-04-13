package code;

public class BSTClosest {

    /*
     * public TreeNode getClosest(TreeNode root, int val) { if(root != null) {
     * TreeNode l = getLeftMostClosest(root, val); TreeNode r =
     * getRightMostClosest(root, val); if(Math.abs(val - l.val) <= Math.abs(val
     * - r.val)) { return l; } else { return r; } } return null; }
     */
    public TreeNode getClosest(TreeNode node, int val) {
	if (node != null) {
	    TreeNode found = null;
	    if (node.val == val)
		return node;
	    if (node.val > val) {
		found = getClosest(node.left, val);
		if (found != null) {
		    return val - found.val < node.val - val ? found : node;
		}
	    } else {
		found = getClosest(node.right, val);
		if (found != null) {
		    return found.val - val < val - node.val ? found : node;
		}
	    }
	}
	return node;
    }

    private TreeNode getLeftMostClosest(TreeNode node, int val) {
	if (node != null) {
	    if (node.val == val)
		return node;
	    if (node.val > val) {
		return getLeftMostClosest(node.left, val);
	    } else {
		TreeNode r = getLeftMostClosest(node.right, val);
		if (r == null) {
		    return node;
		} else {
		    return r;
		}
	    }
	}
	return null;
    }

    private TreeNode getRightMostClosest(TreeNode node, int val) {
	if (node != null) {
	    if (node.val == val)
		return node;
	    if (node.val > val) {
		TreeNode l = getRightMostClosest(node.left, val);
		if (l == null) {
		    return node;
		} else {
		    return l;
		}
	    } else {
		return getRightMostClosest(node.right, val);
	    }
	}
	return null;
    }

    public static void main(String[] args) {
	System.out.println(6 % 6);
	TreeNode root = new TreeNode(600);
	TreeNode n1 = new TreeNode(300);
	TreeNode n2 = new TreeNode(900);
	TreeNode n3 = new TreeNode(100);
	TreeNode n4 = new TreeNode(500);
	TreeNode n5 = new TreeNode(700);
	TreeNode n6 = new TreeNode(1000);
	TreeNode n7 = new TreeNode(400);
	root.left = n1;
	root.right = n2;
	n1.left = n3;
	n1.right = n4;
	n2.left = n5;
	n2.right = n6;
	n4.left = n7;
	BSTClosest sol = new BSTClosest();
	System.out.println(sol.getClosest(root, 490).val);
	System.out.println(sol.getClosest(root, 300).val);
	System.out.println(sol.getClosest(root, 299).val);
	System.out.println(sol.getClosest(root, 601).val);
	System.out.println(sol.getClosest(root, 101).val);

    }

}
