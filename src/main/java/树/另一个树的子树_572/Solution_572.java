/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
package 树.另一个树的子树_572;

import java.util.ArrayDeque;

public class Solution_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(s);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (this.isEqualTree(node, t)) {
                return true;
            }
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return false;
    }

    private boolean isEqualTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                return this.isEqualTree(root1.left, root2.left)
                        && this.isEqualTree(root1.right, root2.right);
            } else {
                return false;
            }
        } else {
            return false;
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
