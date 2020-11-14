package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 排列组合 {

    // 从nums中挑选出k个进行排列
    public List<List<Integer>> arrange(int[] nums, int k) {
        ArrayList<List<Integer>> allArrangements = new ArrayList<>();
        boolean[] used = new boolean[k];
        this.arrangeRec(nums, k - 1, used, new ArrayList<>(), allArrangements);

        return allArrangements;
    }

    private void arrangeRec(int[] nums, int k, boolean[] used, List<Integer> arrangement, List<List<Integer>> allArrangements) {
        if (k == 0) {
            allArrangements.add(new ArrayList<>(arrangement));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    arrangement.add(nums[i]);
                    used[i] = true;
                    this.arrangeRec(nums, k - 1, used, arrangement, allArrangements);
                    used[i] = false;
                    arrangement.remove(arrangement.size() - 1);
                }
            }
        }
    }

    // 从nums中挑选出k个进行组合
    public List<List<Integer>> combine(int[] nums, int k) {
        ArrayList<List<Integer>> allCombination = new ArrayList<>();
        this.combineRec(nums, k, 0, new ArrayList<>(), allCombination);

        return allCombination;
    }

    public void combineRec(int[] nums, int k, int startIndex, List<Integer> combination, List<List<Integer>> allCombination) {
        if (k == 0) {
            allCombination.add(new ArrayList<>(combination));
        } else {
            // 组合与排列的区别在于，已经选过的元素就不能再选了，因此这里是以startIndex作为界限，而非一个used数组。
            // startIndex是单调递增的，startIndex之前的元素都不能选用。
            for (int i = startIndex; i < nums.length; i++) {
                combination.add(nums[i]);
                this.combineRec(nums, k - 1, startIndex + 1, combination, allCombination);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
