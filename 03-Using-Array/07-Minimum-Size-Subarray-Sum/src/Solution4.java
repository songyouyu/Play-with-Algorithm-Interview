/**
 * @author youyusong
 * @date 2018/8/18
 */
public class Solution4 {

    /**
     * 滑动窗口的另外一种实现
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

        int l = 0;
        int r = -1;
        int sum = 0;
        int res = num.length + 1;

        while (r + 1 < num.length) {
            while (r + 1 < num.length && sum < s) {
                r ++;
                sum += num[r];
            }
            if (sum > s) {
                res = Math.min(res, r - l + 1);
            }
            while (l < num.length && sum <= s) {
                sum -= num[l];
                l ++;
                if (sum >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }

        if (res == num.length + 1) {
            return 0;
        } else {
            return 0;
        }
    }

}
