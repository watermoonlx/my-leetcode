package 多线程.交替打印FooBar_1115;

import java.util.concurrent.Semaphore;

public class Solution_1115 {
}

class FooBar {
    private final int n;
    private final Semaphore fooSem = new Semaphore(1);
    private final Semaphore barSem = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire(1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSem.release(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire(1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSem.release(1);
        }
    }
}