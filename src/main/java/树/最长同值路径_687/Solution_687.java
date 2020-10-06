/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
package 树.最长同值路径_687;

public class Solution_687 {

    private int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        this.longestPathFromRoot(root);
        return this.longest;
    }

    private int longestPathFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int longestPathFromLeft = this.longestPathFromRoot(root.left);
        int longestPathFromRight = this.longestPathFromRoot(root.right);

        int pathToLeft = 0;
        if (root.left != null && root.left.val == root.val) {
            pathToLeft = longestPathFromLeft + 1;
        }
        int pathToRight = 0;
        if (root.right != null && root.right.val == root.val) {
            pathToRight = longestPathFromRight + 1;
        }
        if (pathToLeft + pathToRight > this.longest) {
            this.longest = pathToLeft + pathToRight;
        }

        return Math.max(pathToLeft, pathToRight);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}