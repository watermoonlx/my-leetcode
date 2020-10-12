package 多线程.H2O生成_1117;

import java.util.concurrent.Semaphore;

public class Solution_1117 {
}

class H2O {

    private final Semaphore hSem = new Semaphore(2);
    private final Semaphore oSem = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSem.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hSem.release(2);
    }

}