/**
 * @author youyusong
 * @date 2018/8/17
 */
public class Solution2 {

    /**
     * 优化暴力解法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * @param num
     * @param s
     * @return
     */
    public int minSubArrayLen(int[] num, int s) {
        if (num.length == 0 || s <= 0) {
            throw  new IllegalArgumentException("num or index error");
        }

        // sums数组存放num[0]--num[i - 1]的和
        int[] sums = new int[num.length + 1];
        sums[0] = 0;
        for (int i = 1; i < num.length; i ++) {
            sums[i] = sums[i - 1] + num[i - 1];
        }

        int res = num.length + 1;
        for (int l = 0; l < num.length; l ++) {
            for (int r = l; r < num.length; r ++) {
                // 快速获得num[l...r]的值
                if (sums[r + 1] - sums[l] >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }

        if (res == num.length + 1) {
            return 0;
        } else {
            return res;
        }
    }

}
