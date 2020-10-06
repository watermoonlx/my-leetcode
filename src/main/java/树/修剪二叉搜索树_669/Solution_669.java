/**
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
package 树.修剪二叉搜索树_669;

public class Solution_669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return this.trimBST(root.right, L, R);
        } else if (root.val > R) {
            return this.trimBST(root.left, L, R);
        } else {
            root.left = this.trimBST(root.left, L, R);
            root.right = this.trimBST(root.right, L, R);
            return root;
        }
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
