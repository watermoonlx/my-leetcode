package 树.二叉树的层平均值_637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> aves = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int layerSize = q.size();
            double layerSum = 0;
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = q.poll();
                layerSum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            aves.add(layerSum / layerSize);
        }
        return aves;
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
