/**
 * https://leetcode-cn.com/problems/path-sum/
 */
package 树.路径总和_112;

public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return this.hasPathSumRec(root, sum, 0);
    }

    private boolean hasPathSumRec(TreeNode root, int finalSum, int curSum) {
        if (root == null) {
            return false;
        }

        curSum += root.val;
        if (root.left == null && root.right == null) {
            return curSum == finalSum;
        }

        return this.hasPathSumRec(root.left, finalSum, curSum)
                || this.hasPathSumRec(root.right, finalSum, curSum);
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