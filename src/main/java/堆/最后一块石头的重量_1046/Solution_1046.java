package 堆.最后一块石头的重量_1046;

import java.util.PriorityQueue;

public class Solution_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((i, j) -> j - i);
        for (int s : stones) {
            heap.offer(s);
        }

        while (heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();
            int sub = s1 - s2;
            if (sub == 0) {
                continue;
            } else if (sub < 0) {
                sub = -1 * sub;
            }
            heap.offer(sub);
        }

        if (heap.isEmpty()) {
            return 0;
        } else {
            int result = heap.poll();
            return result;
        }
    }
}
