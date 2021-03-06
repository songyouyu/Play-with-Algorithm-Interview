/**
 * leetcode 343
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution1 {

    /**
     * 暴力搜索,会超时
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("exception");
        }

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

        int res = -1;
        for (int i = 1; i < n; i ++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}
