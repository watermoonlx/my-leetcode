/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
package 树.二叉树的堂兄弟节点_993;

import javafx.util.Pair;

import java.util.LinkedList;

public class Solution_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<Pair<TreeNode, TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<>(root, null));
        while (!q.isEmpty()) {
            TreeNode xParent = null;
            TreeNode yParent = null;
            int curLayerSize = q.size();
            for (int i = 1; i <= curLayerSize; i++) {
                Pair<TreeNode, TreeNode> pair = q.poll();
                TreeNode child = pair.getKey();
                TreeNode parent = pair.getValue();
                if (child.val == x) {
                    xParent = parent;
                }
                if (child.val == y) {
                    yParent = parent;
                }
                if (child.left != null) {
                    q.offer(new Pair(child.left, child));
                }
                if (child.right != null) {
                    q.offer(new Pair<>(child.right, child));
                }
            }
            if (xParent != null && yParent != null && xParent != yParent) {
                return true;
            }
        }

        return false;
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