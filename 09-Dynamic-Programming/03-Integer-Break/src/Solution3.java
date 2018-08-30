/**
 * leetcode 343
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution3 {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("exception");
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= i - 1; j ++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}
