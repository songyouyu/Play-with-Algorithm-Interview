/**
 * leetcode 209
 * @author youyusong
 * @date 2018/8/17
 */
public class Solution1 {

    /**
     * 暴力解法(会超时)
     * 时间复杂度: O(n^3)
     * 空间复杂度: O(1)
     * @param num
     * @param s
     * @return
     */
    public int minSubArrayLen(int[] num, int s) {
        if (num.length == 0 || s <= 0) {
            throw  new IllegalArgumentException("num or index error");
        }
        // 定义一个最大值
        int res = num.length + 1;

        for (int l = 0; l < num.length; l ++) {
            for (int r = l; r < num.length; r ++) {
                int sum = 0;
                for (int i = l; i <= r; i ++) {
                    sum += num[i];
                }
                if (sum >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }
        // 若没有找到则返回0
        if (res == num.length + 1) {
            return 0;
        } else {
            return res;
        }

    }

}
