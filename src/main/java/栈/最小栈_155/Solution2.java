package 栈.最小栈_155;

import java.util.ArrayList;

public class Solution2 {
    class MinStack {

        private final ArrayList<Integer> valueStack = new ArrayList<>();
        private final ArrayList<Integer> minValueStack = new ArrayList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int val) {
            this.valueStack.add(val);
            if (this.minValueStack.isEmpty()) {
                this.minValueStack.add(val);
            }else {
                Integer prevMinValue = this.minValueStack.get(this.minValueStack.size() - 1);
                if (val < prevMinValue) {
                    this.minValueStack.add(val);
                } else {
                    this.minValueStack.add(prevMinValue);
                }
            }
        }

        public void pop() {
            this.valueStack.remove(this.valueStack.size() - 1);
            this.minValueStack.remove(this.minValueStack.size() - 1);
        }

        public int top() {
            return this.valueStack.get(this.valueStack.size() - 1);
        }

        public int getMin() {
            return this.minValueStack.get(this.valueStack.size() - 1);
        }
    }
}


