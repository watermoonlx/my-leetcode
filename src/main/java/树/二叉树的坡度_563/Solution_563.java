/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */
package 树.二叉树的坡度_563;

public class Solution_563 {

    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        this.calcSum(root);
        return this.totalTilt;
    }

    private int calcSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        int leftSum = this.calcSum(root.left);
        int rightSum = this.calcSum(root.right);
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;
        return leftSum + rightSum + root.val;
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
