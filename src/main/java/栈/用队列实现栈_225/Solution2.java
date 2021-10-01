package 栈.用队列实现栈_225;

import java.util.ArrayDeque;

public class Solution2 {
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
            ArrayDeque<Integer> activeQ;
            ArrayDeque<Integer> inactiveQ;
            if (!this.q1.isEmpty()) {
                activeQ = this.q1;
                inactiveQ = this.q2;
            } else {
                activeQ = this.q2;
                inactiveQ = this.q1;
            }

            int lastValue = 0;
            while (!activeQ.isEmpty()) {
                lastValue = activeQ.poll();
                if (!activeQ.isEmpty()) {
                    inactiveQ.offer(lastValue);
                }
            }
            return lastValue;
        }

        /**
         * Get the top element.
         */
        public int top() {
            ArrayDeque<Integer> activeQ;
            ArrayDeque<Integer> inactiveQ;
            if (!this.q1.isEmpty()) {
                activeQ = this.q1;
                inactiveQ = this.q2;
            } else {
                activeQ = this.q2;
                inactiveQ = this.q1;
            }

            int lastValue = 0;
            while (!activeQ.isEmpty()) {
                lastValue = activeQ.poll();
                inactiveQ.offer(lastValue);
            }
            return lastValue;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return this.q1.isEmpty() && this.q2.isEmpty();
        }
    }
}
