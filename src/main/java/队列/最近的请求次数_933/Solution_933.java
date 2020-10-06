package 队列.最近的请求次数_933;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution_933 {

}

class RecentCounter {

    private final ArrayList<Integer> pingTimeList = new ArrayList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        this.pingTimeList.add(t);

        int count = 0;
        int lowBoundT = t - 3000;
        for (int i = pingTimeList.size() - 1; i >= 0; i--) {
            Integer pingTime = pingTimeList.get(i);
            if (pingTime <= t && pingTime >= lowBoundT) {
                count++;
            }
        }

        return count;
    }
}