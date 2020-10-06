/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
package 树.二叉树的层次遍历_II_107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int layerSize = q.size();
            ArrayList<Integer> vals = new ArrayList<>();
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.addFirst(vals);
        }
        return result;
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
