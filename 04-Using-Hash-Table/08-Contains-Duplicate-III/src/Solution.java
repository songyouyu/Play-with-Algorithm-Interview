import java.util.TreeSet;

/**
 * leetcode 220
 * @author youyusong
 * @date 2018/8/21
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (treeSet.ceiling((long)nums[i] - (long)t) != null &&
                    treeSet.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t) {
                return true;
            }
            treeSet.add((long)nums[i]);

            if (treeSet.size() == k + 1) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }

}
