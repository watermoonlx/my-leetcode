package 回溯;

import java.util.HashSet;

public class 字符串的排列_剑指Offer_38 {
    public String[] permutation(String s) {
        HashSet<String> allStrs = new HashSet<>();
        this.permutationRec(s, new boolean[s.length()], "", allStrs);
        return allStrs.toArray(new String[0]);
    }

    private void permutationRec(String s, boolean[] used, String curStr, HashSet<String> allStrs) {
        if (curStr.length() == s.length()) {
            allStrs.add(curStr);
        } else {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    this.permutationRec(s, used, curStr + s.substring(i, i + 1), allStrs);
                    used[i] = false;
                }
            }
        }
    }

}
