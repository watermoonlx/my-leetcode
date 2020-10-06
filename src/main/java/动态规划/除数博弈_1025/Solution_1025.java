/**
 * https://leetcode-cn.com/problems/divisor-game/
 */
package 动态规划.除数博弈_1025;

public class Solution_1025 {
    public boolean divisorGame(int N) {
        // 先手结果
        boolean[] firstHandResults = new boolean[N + 1];

        firstHandResults[1] = false; // 输入为1时，先手的人输
        for (int n = 2; n <= N; n++) {
            for (int d = 1; d <= Math.sqrt(n); d++) {
                if (n % d == 0 && !firstHandResults[n - d]) {
                    // 先手选择当前的d，下一个选的人会输，所以当前先手的人会赢。
                    firstHandResults[n] = true;
                    break;
                }
            }
        }

        return firstHandResults[N];
    }
}
