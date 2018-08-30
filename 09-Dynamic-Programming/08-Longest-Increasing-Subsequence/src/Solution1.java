import java.util.Arrays;

/**
 * leetcode 300
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution1 {

    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int res = 1;
        for (int i = 0; i < nums.length; i ++) {
            res = Math.max(res, getMaxLength(nums, i));
        }
        return res;
    }

    private int getMaxLength(int[] nums, int index){
        int res = 1;

        if (memo[index] != -1) {
            return memo[index];
        }

        for (int i = 0; i < index - 1; i ++) {
            if (nums[i] < nums[index]) {
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }

        memo[index] = res;
        return res;
    }
}
