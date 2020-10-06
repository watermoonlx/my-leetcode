/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
package 动态规划.使用最小花费爬楼梯_746;

public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        } else if (cost.length == 1) {
            return cost[0];
        } else if (cost.length == 2) {
            return Math.min(
                    cost[0],
                    cost[1]
            );
        }

        int[] standOnCost = new int[cost.length];
        standOnCost[0] = cost[0];
        standOnCost[1] = cost[1];
        for (int i = 2; i < cost.length - 1; i++) {
            standOnCost[i] = Math.min(
                    standOnCost[i - 1] + cost[i],
                    standOnCost[i - 2] + cost[i]
            );
        }

        return Math.min(
                standOnCost[cost.length - 2],
                standOnCost[cost.length - 3] + cost[cost.length - 1]
        );
    }
}
