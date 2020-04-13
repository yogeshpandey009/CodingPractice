package code;

import java.util.HashSet;
import java.util.Set;

public class TreePathSum {

    int original = Integer.MAX_VALUE;
    Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        TreePathSum s = new TreePathSum();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        System.out.println(s.pathSum(root, 2));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        this.original = sum;
        return dfs(root, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int s = pathSumHelper(root, sum, "H");
        visited = new HashSet<>();
        s += dfs(root.left, sum);
        visited = new HashSet<>();
        s += dfs(root.right, sum);
        return s;
    }

    public int pathSumHelper(TreeNode root, int sum, String pos) {
        String key = pos + ":" + sum;
        // System.out.println("Ent:" + root.val + "@" + key);
        if (visited.contains(key))
            return 0;
        int numOfPaths = 0;
        if (root.val == sum) {
            numOfPaths++;
        }
        if (root.left != null) {
            // numOfPaths += pathSumHelper(root.left, this.original, pos + "L");
            numOfPaths += pathSumHelper(root.left, sum - root.val, pos + "L");
        }
        if (root.right != null) {
            // numOfPaths += pathSumHelper(root.right, this.original, pos +
            // "R");
            numOfPaths += pathSumHelper(root.right, sum - root.val, pos + "R");
        }
        visited.add(key);
        // System.out.println("Ret:" + root.val + "@" + key + "," + numOfPaths);
        return numOfPaths;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
