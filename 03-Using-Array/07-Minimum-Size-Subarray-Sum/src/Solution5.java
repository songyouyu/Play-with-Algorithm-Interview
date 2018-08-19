/**
 * @author youyusong
 * @date 2018/8/18
 */
public class Solution5 {

    /**
     * 对 Solution2 使用二分查找法进行优化
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
            int r = binarySearch(sums, sums[l] + s);
            if (r != sums.length) {
                res = Math.min(res, r - l + 1);
            }
        }

        if (res == num.length + 1) {
            return 0;
        }
        return res;
    }

    private int binarySearch(int[] sums, int target) {
        int l = 0;
        int r = sums.length;
        while (l != r) {
            int mid = l + (r - l) / 2;
            if (sums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
