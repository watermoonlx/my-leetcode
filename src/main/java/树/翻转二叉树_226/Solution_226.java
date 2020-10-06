/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
package 树.翻转二叉树_226;

public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        this.invertTree(root.left);
        this.invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
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