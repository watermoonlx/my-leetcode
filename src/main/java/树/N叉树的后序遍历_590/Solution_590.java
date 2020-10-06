/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
package 树.N叉树的后序遍历_590;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_590 {
    public List<Integer> postorder(Node root) {
        return this.postorderRec(root);
    }

    private List<Integer> postorderRec(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        for (Node child : root.children) {
            result.addAll(this.postorderRec(child));
        }
        result.add(root.val);

        return result;
    }

    private List<Integer> postorderLoop(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curRoot = stack.pop();
            result.addFirst(curRoot.val);
            for (Node child : curRoot.children) {
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