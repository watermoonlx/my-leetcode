/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
package 动态规划.最小路径和_64;

public class Solution_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] resultCache = new int[rowCount][colCount];
        resultCache[0][0] = grid[0][0];
        for (int r = 1; r < rowCount; r++) {
            resultCache[r][0] = resultCache[r - 1][0] + grid[r][0];
        }
        for (int c = 1; c < colCount; c++) {
            resultCache[0][c] = resultCache[0][c - 1] + grid[0][c];
        }
        for (int r = 1; r < rowCount; r++) {
            for (int c = 1; c < colCount; c++) {
                resultCache[r][c] = Math.min(
                        resultCache[r][c - 1] + grid[r][c],
                        resultCache[r - 1][c] + grid[r][c]
                );
            }
        }

        return resultCache[rowCount - 1][colCount - 1];
    }
}
