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

            // 限定了索引的范围
            if (treeSet.size() == k + 1) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        boolean b = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}
