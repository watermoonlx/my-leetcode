package 栈.用队列实现栈_225;

import java.util.ArrayDeque;

public class Solution_225 {
}

class MyStack {

    private final ArrayDeque<Integer> q1 = new ArrayDeque<>();
    private final ArrayDeque<Integer> q2 = new ArrayDeque<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!this.q1.isEmpty()) {
            this.q1.offer(x);
        } else {
            this.q2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        ArrayDeque<Integer> currentQ = !this.q1.isEmpty() ? this.q1 : this.q2;
        ArrayDeque<Integer> otherQ = currentQ == this.q1 ? this.q2 : this.q1;
        Integer lastElement = null;
        while (!currentQ.isEmpty()) {
            lastElement = currentQ.poll();
            if (!currentQ.isEmpty()) {
                otherQ.offer(lastElement);
            }
        }
        return lastElement;
    }

    /**
     * Get the top element.
     */
    public int top() {
        ArrayDeque<Integer> currentQ = !this.q1.isEmpty() ? this.q1 : this.q2;
        ArrayDeque<Integer> otherQ = currentQ == this.q1 ? this.q2 : this.q1;
        Integer lastElement = null;
        while (!currentQ.isEmpty()) {
            lastElement = currentQ.poll();
            otherQ.offer(lastElement);
        }

        return lastElement;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.q1.isEmpty() && this.q2.isEmpty();
    }
}