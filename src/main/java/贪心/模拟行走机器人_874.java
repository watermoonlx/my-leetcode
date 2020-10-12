package 贪心;

import java.util.Arrays;
import java.util.HashSet;

public class 模拟行走机器人_874 {

    private static final int[] UP = {0, 1};
    private static final int[] LEFT = {-1, 0};
    private static final int[] DOWN = {0, -1};
    private static final int[] RIGHT = {1, 0};
    private final HashSet<Integer> obstacleSet = new HashSet<>();

    public int robotSim(int[] commands, int[][] obstacles) {
        for (int[] obstacle : obstacles) {
            this.obstacleSet.add(((obstacle[0] + 30000) << 16) + (obstacle[1] + 30000));
        }

        int[] pos = {0, 0};
        int maxDist = 0;
        int[] step = UP;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                step = this.turnLeft(step);
            } else if (commands[i] == -1) {
                step = this.turnRight(step);
            } else {
                for (int j = 1; j <= commands[i]; j++) {
                    int[] nextPos = {pos[0] + step[0], pos[1] + step[1]};
                    if (this.isObstacle(nextPos)) {
                        break;
                    } else {
                        pos = nextPos;
                    }
                }
                maxDist = Math.max(maxDist, pos[0] * pos[0] + pos[1] * pos[1]);
            }
        }

        return maxDist;
    }

    private int[] turnLeft(int[] step) {
        if (step == UP) {
            return LEFT;
        } else if (step == LEFT) {
            return DOWN;
        } else if (step == DOWN) {
            return RIGHT;
        } else {
            return UP;
        }
    }

    private int[] turnRight(int[] step) {
        if (step == UP) {
            return RIGHT;
        } else if (step == RIGHT) {
            return DOWN;
        } else if (step == DOWN) {
            return LEFT;
        } else {
            return UP;
        }
    }

    private boolean isObstacle(int[] pos) {
        return this.obstacleSet.contains(((pos[0] + 30000) << 16) + (pos[1] + 30000));
    }

    public static void main(String[] args) {
        new 模拟行走机器人_874().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}});
    }
}
