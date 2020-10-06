package 多线程.按序打印_1114;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution_1114 {
    public static void main(String[] args) {
    }
}

class Foo {

    private ReentrantLock lock = new ReentrantLock();
    private volatile boolean firstDoneFlag = false;
    private volatile boolean secondDoneFlag = false;
    private Condition firstDone = lock.newCondition();
    private Condition secondDone = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        this.lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            this.firstDoneFlag = true;
            this.firstDone.signal();
        }
        finally {
            this.lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        this.lock.lock();
        try {
            while (!this.firstDoneFlag) {
                this.firstDone.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            this.secondDoneFlag = true;
            this.secondDone.signal();
        }
        finally {
            this.lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        this.lock.lock();
        try {
            while (!this.secondDoneFlag) {
                this.secondDone.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
        finally {
            this.lock.unlock();
        }
    }
}