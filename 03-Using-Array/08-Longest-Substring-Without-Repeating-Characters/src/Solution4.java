
/**
 * @author youyusong
 * @date 2018/8/19
 */
public class Solution4 {


    /**
     * 基于Solution1, 若s[r + 1]之前出现过，则l可以直接跳到之前
     * s[r + 1]出现的位置 +1 的地方
     * 时间复杂度: O(len(s)*len(charset))
     * 空间复杂度: O(1)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];

        int l = 0;
        int r = 0;
        int res = 0;

        while (r + 1 < s.length()) {
            int index = isDuplicateChar(s, l, r);

            if (index != -1) {
                l = index + 1;
            }

            res = Math.max(res, r - l + 1);

            r ++;
        }
        return res;
    }

    private int isDuplicateChar(String s, int l, int r) {
        for (int i = l; i < r; i ++) {
            if (s.charAt(i) == s.charAt(r)) {
                return i;
            }
        }
        return -1;
    }
}
