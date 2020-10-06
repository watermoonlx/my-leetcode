package 动态规划.爬楼梯_70;

public class Solution_70 {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int prev2 = 1;
        int prev1 = 2;
        int cur = prev1;
        for (int i = 3; i <= n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }
}
