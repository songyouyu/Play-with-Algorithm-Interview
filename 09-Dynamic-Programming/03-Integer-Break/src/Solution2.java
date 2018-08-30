import java.util.Arrays;

/**
 * leetcode 343
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution2 {

    private int[] memo;

    public int integerBreak(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("exception");
        }
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return breakInteger(n);
    }

    /**
     * 将 n 至少分割成两部分, 求分割部分的乘积的最大值
     * @param n
     * @return
     */
    private int breakInteger(int n){
        if (n == 1) {
            return 1;
        }

        // 说明 memo[n] 计算过,不需要重复计算
        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i ++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

}
