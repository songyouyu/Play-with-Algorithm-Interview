
/**
 * leetcode 70
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution2 {

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];

        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i ++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
