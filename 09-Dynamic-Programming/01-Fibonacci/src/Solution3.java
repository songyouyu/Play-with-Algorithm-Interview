import java.util.Arrays;

/**
 * 动态规划(自底向上)
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution3 {

    public int fib(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i ++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n];
    }
}
