/**
 * @author youyusong
 * @date 2018/8/19
 */
public class Solution3 {

    /**
     * 时间复杂度: O(len(s))
     * 空间复杂度: O(len(charset))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];

        int l = 0;
        int r = -1;
        int res = 0;

        while (r + 1 < s.length()) {
            while (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r ++;
                freq[s.charAt(r)] ++;
            }

            res = Math.max(res, r - l + 1);

            // 若能进入此if条件，则 freq[s.charAt(r + 1)] == 1
            if (r + 1 < s.length()) {
                r ++;
                freq[s.charAt(r)] ++;
                if (l <= r && freq[s.charAt(r)] == 2) {
                    freq[s.charAt(l)] --;
                    l ++;
                }
            }
        }
        return res;
    }
}
