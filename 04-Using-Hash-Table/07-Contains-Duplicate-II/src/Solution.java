import java.util.HashSet;

/**
 * leetcode 219
 * @author youyusong
 * @date 2018/8/21
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);

            if (hashSet.size() == k + 1) {
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
