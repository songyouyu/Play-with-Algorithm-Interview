/**
 * leetcode 198
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution2 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        memo[n -1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i --) {
            for (int j = i; j < n; j ++) {
                memo[i] = Math.max(memo[i], memo[j] + (j + 2 > n ? 0 : memo[j + 2] ));
            }
        }
        return memo[0];
    }
}
