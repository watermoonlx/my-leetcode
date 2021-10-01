package 栈.用栈实现队列_232;

import java.util.ArrayDeque;

public class Solution2 {

    class MyQueue {

        private final ArrayDeque<Integer> inputStack = new ArrayDeque<>();
        private final ArrayDeque<Integer> outputStack = new ArrayDeque<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            this.inputStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (this.outputStack.isEmpty()) {
                while (!this.inputStack.isEmpty()) {
                    this.outputStack.push(this.inputStack.pop());
                }
            }
            return this.outputStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (this.outputStack.isEmpty()) {
                while (!this.inputStack.isEmpty()) {
                    this.outputStack.push(this.inputStack.pop());
                }
            }
            return this.outputStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.inputStack.isEmpty() && this.outputStack.isEmpty();
        }
    }

}
