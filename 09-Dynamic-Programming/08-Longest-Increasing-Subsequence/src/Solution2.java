import java.util.Arrays;

/**
 * leetcode 300
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution2 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 1;
        for (int i = 1; i <nums.length; i ++) {
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {10,9,2,5,3,7,101,18};
        int length = solution.lengthOfLIS(nums);
        System.out.println(length);
    }
}
