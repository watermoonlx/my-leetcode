package 多线程.哲学家进餐_1226;

public class Solution_1226 {
}

class DiningPhilosophers {

    private static Object[] forkLocks = new Object[5];

    public DiningPhilosophers() {
        for (int i = 0; i < forkLocks.length; i++) {
            this.forkLocks[i] = new Object();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftForkIndex = philosopher;
        int rightForkIndex = philosopher - 1;
        if (rightForkIndex < 0) {
            rightForkIndex = 5 + rightForkIndex;
        }
        int biggerIndex = leftForkIndex > rightForkIndex ? leftForkIndex : rightForkIndex;
        int smallerIndex = leftForkIndex > rightForkIndex ? rightForkIndex : leftForkIndex;
        synchronized (forkLocks[biggerIndex]) {
            synchronized (forkLocks[smallerIndex]) {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
            }
        }
    }
}