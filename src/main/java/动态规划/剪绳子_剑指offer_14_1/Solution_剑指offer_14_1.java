package 动态规划.剪绳子_剑指offer_14_1;

public class Solution_剑指offer_14_1 {
    public int cuttingRope(int n) {
        int[] maxProducts = new int[n + 1]; // 不同长度的绳子的最大乘积
        maxProducts[1] = 1;
        for (int len = 2; len <= n; len++) {
            int maxProduct = 0;
            for (int partialLen = 1; partialLen <= len / 2; partialLen++) {
                int product = Math.max(maxProducts[partialLen], partialLen) *
                        Math.max(maxProducts[len - partialLen], len - partialLen);
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
            maxProducts[len] = maxProduct;
        }
        return maxProducts[n];
    }
}
