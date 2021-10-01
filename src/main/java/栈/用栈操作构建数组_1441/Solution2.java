package 栈.用栈操作构建数组_1441;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> actionList = new ArrayList<>();
        int targetIndex = 0;
        for (int num = 1; num <= n && targetIndex < target.length; num++) {
            actionList.add("Push");
            if (num == target[targetIndex]) {
                targetIndex++;
            } else {
                actionList.add("Pop");
            }
        }
        return actionList;
    }
}
