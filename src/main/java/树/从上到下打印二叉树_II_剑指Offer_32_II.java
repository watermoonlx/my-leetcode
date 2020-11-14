package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 从上到下打印二叉树_II_剑指Offer_32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> curLayer = new LinkedList<>();
        LinkedList<TreeNode> nextLayer = new LinkedList<>();
        curLayer.offer(root);
        ArrayList<Integer> curLayerVals = new ArrayList<>();
        while (!curLayer.isEmpty()) {
            TreeNode node = curLayer.poll();
            if (node != null) {
                curLayerVals.add(node.val);
                nextLayer.offer(node.left);
                nextLayer.offer(node.right);
            }
            if (curLayer.isEmpty()) {
                curLayer = nextLayer;
                nextLayer = new LinkedList<>();
                if (!curLayerVals.isEmpty()) {
                    ans.add(curLayerVals);
                    curLayerVals = new ArrayList<>();
                }
            }
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

