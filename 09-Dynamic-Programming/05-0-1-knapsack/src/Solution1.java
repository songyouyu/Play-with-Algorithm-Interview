/**
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution1 {

    private int[][] memo;

    /**
     * 0-1背包问题
     * w: 单个物品的容量
     * v: 单个物品的价值
     * C: 背包容量
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knapsack01(int[] w, int[] v, int C){
        if (C < 0) {
            throw new IllegalArgumentException("exception");
        }

        if(w == null || v == null || w.length != v.length) {
            throw new IllegalArgumentException("exception");
        }

        // 物品个数
        int n = w.length;
        if (n == 0 || C == 0) {
            return 0;
        }
        memo = new int[n][C + 1];
        return bestValue(w, v, n - 1, C);
    }

    private int bestValue(int[] w, int[] v, int index, int c){
        if (c <= 0 || index < 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        // 先不管新加入的
        int res = bestValue(w, v, index - 1, c);
        if (c > w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        return memo[index][c] = res;
    }
}
