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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 0, 1, 1};
        boolean result = solution.containsNearbyDuplicate(nums, 1);
        System.out.println(result);
    }
}


