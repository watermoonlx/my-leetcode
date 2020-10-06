/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 该题与“最长同值路径”类似：https://leetcode-cn.com/problems/longest-univalue-path/
 */
package 树.二叉树的直径_543;

public class Solution_543 {

    private int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.maxPathLength(root);
        return this.maxLength;
    }

    public int maxPathLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxPathLength = 0;
        if (root.left != null) {
            leftMaxPathLength = this.maxPathLength(root.left) + 1;
        }
        int rightMaxPathLength = 0;
        if (root.right != null) {
            rightMaxPathLength = this.maxPathLength(root.right) + 1;
        }
        this.maxLength = Math.max(this.maxLength, leftMaxPathLength + rightMaxPathLength);

        return Math.max(leftMaxPathLength, rightMaxPathLength);
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