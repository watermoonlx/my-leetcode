/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
package 树.二叉搜索树中的众数_501;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_501 {


    public int[] findMode(TreeNode root) {
        ArrayList<Integer> midOrderList = new ArrayList<>();
        this.traverse(root, midOrderList);
        if (midOrderList.size() == 0) {
            return new int[0];
        }
        int curVal = midOrderList.get(0);
        int curLength = 0;
        int maxLength = 0;
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 1; i < midOrderList.size(); i++) {
            if (midOrderList.get(i) == curVal) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    ans.clear();
                    ans.add(curVal);
                    maxLength = curLength;
                } else if (curLength == maxLength) {
                    ans.add(curVal);
                }

                curVal = midOrderList.get(i);
                curLength = 0;
            }
        }
        if (curLength > maxLength) {
            ans.clear();
            ans.add(curVal);
        } else if (curLength == maxLength) {
            ans.add(curVal);
        }

        int[] finalResult = new int[ans.size()];
        int i = 0;
        for (int val : ans) {
            finalResult[i++] = val;
        }
        return finalResult;
    }

    public void traverse(TreeNode root, List<Integer> midOrderList) {
        if (root == null) {
            return;
        }
        this.traverse(root.left, midOrderList);
        midOrderList.add(root.val);
        this.traverse(root.right, midOrderList);
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