/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
package 排序.有效的字母异位词_242;

public class Solution_242 {
    // 用Hash表来保存字母出现的频率是更好的做法。这里是为了练习排序算法才使用排序来解。
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCodePoints = s.codePoints().toArray();
        int[] tCodePoints = t.codePoints().toArray();
        this.sort(sCodePoints);
        this.sort(tCodePoints);
        for (int i = 0; i < sCodePoints.length; i++) {
            if (sCodePoints[i] != tCodePoints[i]) {
                return false;
            }
        }
        return true;
    }

    private void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            for (; j - 1 >= 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }
}


