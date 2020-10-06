/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
package 树.左叶子之和_404;

public class Solution_404 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.sumOfLeftLeavesRec(root.left, root);
        this.sumOfLeftLeavesRec(root.right, root);
        return this.sum;
    }

    public void sumOfLeftLeavesRec(TreeNode cur, TreeNode parent) {
        if (cur == null) {
            return;
        }

        if (cur.left == null && cur.right == null && cur == parent.left) {
            this.sum += cur.val;
        }

        this.sumOfLeftLeavesRec(cur.left, cur);
        this.sumOfLeftLeavesRec(cur.right, cur);
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
