/**
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution1 {

    private int[][] memo;

    /**
     * 0-1背包问题(记忆化搜索)
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
        // 0 到 C，所以是 C + 1
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

        // 第一种策略：先不管新加入的, 不考虑 Index, 只考虑 [0...index-1]
        int res = bestValue(w, v, index - 1, c);
        // 第二种策略：把 index 位置的物品放入背包里
        if (c > w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;

        return res;
    }
}
