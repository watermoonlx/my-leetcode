/**
 *
 */
package 树.对称二叉树_101;

import java.util.ArrayDeque;

public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        return this.isSymmetricLoop(root);
    }

    // 递归
    public boolean isSymmetricRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            if (root1.val != root2.val) {
                return false;
            } else {
                return this.isSymmetricRec(root1.left, root2.right)
                        && this.isSymmetricRec(root1.right, root2.left);
            }
        } else {
            return false;
        }
    }

    // 循环
    public boolean isSymmetricLoop(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        q.offer(root);
        while (q.size() > 0) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if (node1.val != node2.val) {
                return false;
            }

            if (node1.left != null && node2.right != null) {
                q.offer(node1.left);
                q.offer(node2.right);
            } else if (!(node1.left == null && node2.right == null)) {
                return false;
            }

            if (node1.right != null && node2.left != null) {
                q.offer(node1.right);
                q.offer(node2.left);
            } else if (!(node1.right == null && node2.left == null)) {
                return false;
            }
        }

        return true;
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