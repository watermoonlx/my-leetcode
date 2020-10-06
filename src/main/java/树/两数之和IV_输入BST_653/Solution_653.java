/**
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
package 树.两数之和IV_输入BST_653;

import java.util.ArrayList;

public class Solution_653 {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> orderedList = new ArrayList<>();
        this.dfs(root, orderedList);

        int minCursor = 0;
        int maxCursor = orderedList.size() - 1;
        while (minCursor < maxCursor) {
            int minVal = orderedList.get(minCursor);
            int maxVal = orderedList.get(maxCursor);
            int sum = minVal + maxVal;
            if (sum < k) {
                minCursor++;
            } else if (sum > k) {
                maxCursor--;
            } else {
                return true;
            }
        }

        return false;
    }

    public void dfs(TreeNode root, ArrayList<Integer> orderedList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            this.dfs(root.left, orderedList);
        }
        orderedList.add(root.val);
        if (root.right != null) {
            this.dfs(root.right, orderedList);
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
