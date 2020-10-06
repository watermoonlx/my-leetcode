/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 */
package 多线程.打印零与奇偶数_1116;

import java.util.function.IntConsumer;

public class Solution_1116 {
}

class ZeroEvenOdd {
    private int n;
    private int hasPrintN = 0;
    private boolean zeroTurn = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted() && !this.zeroTurn) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printNumber.accept(0);
                this.zeroTurn = false;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted()
                        && (this.zeroTurn || this.hasPrintN % 2 == 0)) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printNumber.accept(++this.hasPrintN);
                this.zeroTurn = true;
                this.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted()
                        && (this.zeroTurn || this.hasPrintN % 2 == 1)) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printNumber.accept(++this.hasPrintN);
                this.zeroTurn = true;
                this.notifyAll();
            }
        }
    }

    private boolean isCompleted() {
        return this.hasPrintN == n;
    }
}