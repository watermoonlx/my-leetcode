package 多线程.H2O生成_1117;

public class Solution_1117 {
}

class H2O {

    private volatile int h_count = 2;
    private volatile int o_count = 1;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (this.h_count == 0) {
                this.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            this.h_count--;
            this.checkAndReset();
            this.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (this.o_count == 0) {
                this.wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            this.o_count--;
            this.checkAndReset();
            this.notifyAll();
        }
    }

    private void checkAndReset() {
        if(this.h_count==0 && this.o_count==0) {
            this.h_count = 2;
            this.o_count = 1;
        }
    }
}