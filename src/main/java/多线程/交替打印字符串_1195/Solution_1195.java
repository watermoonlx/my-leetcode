package 多线程.交替打印字符串_1195;

import java.util.function.IntConsumer;

public class Solution_1195 {

}

class FizzBuzz {
    private final int n;
    private volatile int hasPrintN = 0;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted()
                        && ((this.hasPrintN + 1) % 3 != 0 || (this.hasPrintN + 1) % 5 == 0)) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printFizz.run();
                ++this.hasPrintN;
                this.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted()
                        && ((this.hasPrintN + 1) % 5 != 0 || (this.hasPrintN + 1) % 3 == 0)) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printBuzz.run();
                ++this.hasPrintN;
                this.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted()
                        && ((this.hasPrintN + 1) % 5 != 0 || (this.hasPrintN + 1) % 3 != 0)) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printFizzBuzz.run();
                ++this.hasPrintN;
                this.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (!this.isCompleted()
                        && ((this.hasPrintN + 1) % 5 == 0 || (this.hasPrintN + 1) % 3 == 0)) {
                    this.wait();
                }
                if (this.isCompleted()) {
                    this.notifyAll();
                    break;
                }
                printNumber.accept(++this.hasPrintN);
                this.notifyAll();
            }
        }
    }

    private boolean isCompleted() {
        return this.hasPrintN == this.n;
    }
}