package 栈.商品折扣后的最终价格_1475;

import java.util.ArrayDeque;

public class Solution {
    public int[] finalPrices(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] lowerPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            lowerPrices[i] = currentPrice;
            while (!stack.isEmpty() && (prices[stack.peek()] >= currentPrice)) {
                Integer tempIndex = stack.pop();
                lowerPrices[tempIndex] = prices[tempIndex] - currentPrice;
            }
            stack.push(i);
        }
        return lowerPrices;
    }
}
