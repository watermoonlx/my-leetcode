/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
package 树.N叉树的前序遍历_589;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution_589 {
    public List<Integer> preorder(Node root) {
        return this.preorderRec(root);
    }

    public List<Integer> preorderRec(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        for (Node child : root.children) {
            result.addAll(this.preorderRec(child));
        }
        return result;
    }

    public List<Integer> preorderLoop(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curRoot = stack.pop();
            result.add(curRoot.val);
            for (int i = curRoot.children.size() - 1; i >= 0; i--) {
                Node child = curRoot.children.get(i);
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};