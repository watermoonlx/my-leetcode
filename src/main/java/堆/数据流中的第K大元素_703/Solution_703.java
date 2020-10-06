/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
package 堆.数据流中的第K大元素_703;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.PriorityQueue;

public class Solution_703 {
    public static void main(String[] args) {

    }
}

class KthLargest {

    private final PriorityQueue<Integer> heap;
    private final int capacity;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.capacity = k;
        for (int n : nums) {
            this.add(n);
        }
    }

    public int add(int val) {
        if (this.heap.size() < this.capacity) {
            this.heap.offer(val);
        } else {
            if (this.heap.peek() < val) {
                this.heap.poll();
                this.heap.offer(val);
            }
        }

        return this.heap.peek();
    }
}