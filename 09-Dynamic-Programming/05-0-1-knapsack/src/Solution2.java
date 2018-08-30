/**
 * @author youyusong
 * @date 2018/8/30
 */
public class Solution2 {

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
        int[][] memo = new int[n][C + 1];

        for (int j = 0; j <= C; j ++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0 );
        }

        for(int i = 1 ; i < n ; i ++) {
            for(int j = 0 ; j <= C ; j ++){
                memo[i][j] = memo[i-1][j];
                if(j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n - 1][C];
    }
}
