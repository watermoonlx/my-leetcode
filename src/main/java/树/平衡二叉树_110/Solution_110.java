/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
package 树.平衡二叉树_110;

public class Solution_110 {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        this.calcHeight(root);
        return this.isBalanced;
    }

    private int calcHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = this.calcHeight(root.left);
        int rightHeight = this.calcHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            this.isBalanced = false;
        }
        int rootHeight = Math.max(leftHeight, rightHeight) + 1;
        return rootHeight;
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