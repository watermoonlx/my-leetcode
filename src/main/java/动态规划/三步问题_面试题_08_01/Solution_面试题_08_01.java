/**
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
package 动态规划.三步问题_面试题_08_01;

public class Solution_面试题_08_01 {
    public int waysToStep(int n) {
        if (n <= 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            long[] resultCache = new long[n + 1];
            resultCache[0] = 1;
            resultCache[1] = 1;
            resultCache[2] = 2;
            for (int i = 3; i <= n; i++) {
                resultCache[i] = (resultCache[i - 1] + resultCache[i - 2] + resultCache[i - 3]) % 1000000007;
            }

            return (int)resultCache[n];
        }
    }
}
