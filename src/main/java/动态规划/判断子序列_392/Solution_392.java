package 动态规划.判断子序列_392;

public class Solution_392 {

    private static int DONE = -1;
    private static int FAILED = -2;

    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenT == 0) {
            return lenS == 0;
        }

        // s1 -'a'-> s2 -'b'-> s3 -'c'-> s4
        int[][] dfs = new int[lenT][26];

        for (int i = 0; i < 26; i++) {
            if (t.charAt(lenT - 1) == 'a' + i) {
                dfs[lenT - 1][i] = DONE;
            } else {
                dfs[lenT - 1][i] = FAILED;
            }
        }

        for (int i = lenT - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j) {
                    dfs[i][j] = i + 1;
                } else {
                    dfs[i][j] = dfs[i + 1][j];
                }
            }
        }

        int state = 0;
        for (int i = 0; i < lenS; i++) {
            state = dfs[state][s.charAt(i) - 'a'];
            if (state == FAILED) {
                return false;
            } else if (state == DONE && i < lenS - 1) {
                return false;
            }
        }

        return true;
    }
}
