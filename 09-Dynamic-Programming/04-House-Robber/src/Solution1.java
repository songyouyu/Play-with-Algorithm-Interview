import java.util.Arrays;

/**
 * leetcode 198
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution1 {

    private int[] memo;

    /**
     * 记忆化搜索
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i ++) {
            res = Math.max(res, nums[i] + tryRob(nums, nums[i + 2]));
        }
        memo[index] = res;
        return res;
    }

}
