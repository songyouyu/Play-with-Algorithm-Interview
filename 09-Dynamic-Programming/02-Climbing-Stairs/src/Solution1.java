import java.util.Arrays;

/**
 * leetcode 70
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {
        // 从0 到 1 有 n + 1 个元素
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }
        return memo[n];
    }

}
