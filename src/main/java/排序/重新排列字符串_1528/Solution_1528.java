/**
 * https://leetcode-cn.com/problems/shuffle-string/
 */
package 排序.重新排列字符串_1528;

public class Solution_1528 {

    public static void main(String[] args) {
        new Solution_1528().restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3});
    }

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int curIndex = i;
            int correctIndex = indices[curIndex];
            while (curIndex != correctIndex) {
                char temp = chars[correctIndex];
                chars[correctIndex] = chars[curIndex];
                chars[curIndex] = temp;

                int tempIndex = indices[curIndex];
                indices[curIndex] = indices[correctIndex];
                indices[correctIndex] = tempIndex;

                correctIndex = indices[curIndex];
            }
        }
        return String.valueOf(chars);
    }
}

