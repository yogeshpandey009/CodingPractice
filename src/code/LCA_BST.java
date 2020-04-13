package code;

public class LCA_BST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (root == null || root == p || root == q)
	    return root;
	if (p.val < root.val && q.val < root.val) {
	    return lowestCommonAncestor(root.left, p, q);
	} else if (p.val > root.val && q.val > root.val) {
	    return lowestCommonAncestor(root.right, p, q);
	}
	return root;
    }

}