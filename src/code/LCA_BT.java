package code;

public class LCA_BT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (root != null) {
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    if (left != null && right != null) {
		return root;
	    } else if (left != null) {
		if (root == p || root == q) {
		    return root;
		}
		return left;
	    } else if (right != null) {
		if (root == p || root == q) {
		    return root;
		}
		return right;
	    } else if (root == p || root == q)
		return root;
	    else
		return null;
	}
	return null;
    }
}