/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
package 树.二叉树的最小深度_111;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> curLayerQ = new LinkedList<>();
        LinkedList<TreeNode> nextLayerQ = new LinkedList<>();
        curLayerQ.offer(root);
        int layerCount = 1;
        while (!curLayerQ.isEmpty()) {
            TreeNode node = curLayerQ.poll();
            if (node.left == null && node.right == null) {
                break;
            } else {
                if (node.left != null) {
                    nextLayerQ.offer(node.left);
                }
                if (node.right != null) {
                    nextLayerQ.offer(node.right);
                }

                if (curLayerQ.isEmpty()) {
                    curLayerQ = nextLayerQ;
                    nextLayerQ = new LinkedList<>();
                    layerCount++;
                }
            }
        }
        return layerCount;
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
