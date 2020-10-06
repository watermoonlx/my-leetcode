/**
 * https://leetcode-cn.com/problems/word-break/
 */
package 动态规划.单词拆分_139;

import java.util.HashSet;
import java.util.List;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        boolean[] breakPoints = new boolean[s.length() + 1];
        breakPoints[0] = true;
        for (int i = 1; i < breakPoints.length; i++) {
            for (int j = 0; j < i; j++) {
                breakPoints[i] = breakPoints[j] && words.contains(s.substring(j, i));
                if (breakPoints[i]) {
                    break;
                }
            }
        }
        return breakPoints[s.length()];
    }
}
