/**
 * https://leetcode-cn.com/problems/min-stack/
 */
package 栈.最小栈_155;

import java.util.ArrayDeque;

public class Solution_155 {
    public static void main(String[] args) {
    }
}

class MinStack {

    private final ArrayDeque<Integer> stack = new ArrayDeque<>();
    private final ArrayDeque<Integer> minStack = new ArrayDeque<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        this.stack.push(x);
        if (this.minStack.isEmpty()) {
            this.minStack.push(x);
        } else {
            int currentMin = this.minStack.peek();
            if (x < currentMin) {
                this.minStack.push(x);
            } else {
                this.minStack.push(currentMin);
            }
        }
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}
