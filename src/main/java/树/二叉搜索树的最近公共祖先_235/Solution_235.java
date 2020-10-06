/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
package 树.二叉搜索树的最近公共祖先_235;

public class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int min = p.val < q.val ? p.val : q.val;
        int max = p.val + q.val - min;
        if (root.val < min) {
            return this.lowestCommonAncestor(root.right, p, q);
        } else if (root.val > max) {
            return this.lowestCommonAncestor(root.left, p, q);
        } else {
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