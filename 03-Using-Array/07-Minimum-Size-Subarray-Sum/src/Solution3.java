/**
 * @author youyusong
 * @date 2018/8/18
 */
public class Solution3 {

    /**
     * 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param num
     * @param s
     * @return
     */
    public int minSubArrayLen(int[] num, int s) {
        if (num.length == 0 || s <= 0) {
            throw  new IllegalArgumentException("num or index error");
        }

        // num[l...r]为滑动窗口
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = num.length + 1;

        // 在数组界限内，可以继续滑动
        while (l < num.length) {
            if (r + 1 < num.length && sum < s) {
                r ++;
                sum += num[r];
            } else {
                sum -= num[l];
                l ++;
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == num.length + 1) {
            return 0;
        } else {
            return res;
        }
    }

}
